package com.example.job.semaphore;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PinYin4JTest {

    @Test
    public void test01(){
        List<String> names = new ArrayList<>();
        names.add("柴老师");
        names.add("王老师");
        names.add("苍老师");
        names.add("老王");
        names.add("老李");
        names.add("小泽老师");

        Collections.sort(names,(s1,s2)->
        {
            String p1 = "";
            String p2 = "";
            for (int i = 0; i < s1.length(); i++) {
                p1 += PinyinHelper.toHanyuPinyinStringArray(s1.charAt(i))[0];
            }
            for (int i = 0; i < s2.length(); i++) {
                p2 += PinyinHelper.toHanyuPinyinStringArray(s2.charAt(i))[0];
            }
            return p1.compareTo(p2);
        });
        System.out.println(names);
    }
}
