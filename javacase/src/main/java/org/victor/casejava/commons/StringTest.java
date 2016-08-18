package org.victor.casejava.commons;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

/**
 * apache commons包的字符串增强处理
 * Created by zhengcunwen on 2016/8/18.
 */

public class StringTest {


    /**list或者array转字符串，特殊符号分割**/
    @Test
    public void listToString(){
        List<Integer> list = Lists.newArrayList(1,3,5,2,223,12);
        String to = StringUtils.join(list, ",");

        System.out.println(to);
    }

    /**计算字符串sub在字符串str中出现的次数**/
    @Test
    public void matchesCount(){
        int a1 = StringUtils.countMatches(null, "*"); // *号代表，任意字符
        int a2 = StringUtils.countMatches("", "*");   // *号代表，任意字符
        int a3 = StringUtils.countMatches("asdf","as");
        int a4 = StringUtils.countMatches("asdfas","as");
        int a5 = StringUtils.countMatches("dfgh","as");
        int a6 = StringUtils.countMatches("as","");
        int a7 = StringUtils.countMatches("as",null);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println(a6);
        System.out.println(a7);
    }

    /**判断某字符串是否为空，为空的标准是str == null 或 str.length() == 0**/
    @Test
    public void isEmpty(){
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty("  "));
        System.out.println(StringUtils.isEmpty("        "));
        System.out.println(StringUtils.isEmpty("bob"));
        System.out.println(StringUtils.isEmpty(" bob "));
    }




    /**把字符串中的字符大写转换为小写，小写转换为大写 ,字符串大小写反转**/
    @Test
    public void swapCase(){
        System.out.println(StringUtils.swapCase(null));
        System.out.println(StringUtils.swapCase(""));
        System.out.println(StringUtils.swapCase("Hello Boys"));
        System.out.println(StringUtils.swapCase("I am 11"));
    }
}
