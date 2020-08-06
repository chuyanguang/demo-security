package com.example.job.semaphore;

import lombok.Data;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    @Test
    public void test01() {
        Semaphore semaphore = new Semaphore(1, true);
        Business business = new Business();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                business.sub(i);
                semaphore.release();
            }
        }).start();
        for (int i = 1; i <= 10; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            business.main(i);
            semaphore.release();
        }
    }

    @Test
    public void test02() {
        Business business = new Business();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                business.sub(i);
            }
        }).start();
        for (int i = 1; i <= 10; i++) {
            business.main(i);
        }
    }

    @Test
    public void test03() {
        Semaphore sp = new Semaphore(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                try {
                    sp.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(sp.availablePermits());
                sp.release();
            });
        }
    }
}

@Data
class Business {

    private boolean check = true;

    public synchronized void sub(int i) {
        while (!check) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub run " + j + ",total " + i);
        }
        check = false;
        this.notify();
    }

    public synchronized void main(int i) {
        while (check) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 20; j++) {
            System.out.println(j + "------" + i);
        }
        check = true;
        this.notify();
    }
}