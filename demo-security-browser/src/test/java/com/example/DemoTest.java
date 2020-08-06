package com.example;

import com.example.service.SmsService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecurityBrowserApplicaton.class)
public class DemoTest {

    @Autowired
    private Map<String, SmsService> smsServices;

    @Test
    public void test01() {
        smsServices.forEach((s, smsService) -> {
            System.out.println("key:" + s + ", value:" + smsService.toString());
        });
    }

    @Test
    public void test02(){
        List<String> list = Lists.newArrayList("张三", "李四", "王五");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
        }
    }

}
