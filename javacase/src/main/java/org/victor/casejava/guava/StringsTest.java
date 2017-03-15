package org.victor.casejava.guava;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * guava的string测试类
 * Created by zhengcunwen on 2017/3/15.
 */
public class StringsTest {

    /** 空串转换为null或者字符串值 **/
    @Test
    public void emptyToNull(){
        System.out.println(Strings.emptyToNull(""));
        System.out.println(Strings.emptyToNull(null));
        System.out.println(Strings.emptyToNull("abcd"));
    }


    /** null转换为空串或者字符串值 **/
    @Test
    public void nullToEmpty(){
        System.out.println(Strings.nullToEmpty(""));
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.nullToEmpty("abcd"));
    }

    /** 判断null或者empty **/
    @Test
    public void isNullOrEmpty(){
        System.out.println(Strings.isNullOrEmpty(""));
        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty("abcd"));
    }

    /** 字符串复制 **/
    @Test
    public void repeat(){
        System.out.println(Strings.repeat("阿斯顿",2));
    }

    /** 固定位置补字符串内容 **/
    @Test
    public void pad(){
        System.out.println(Strings.padEnd("abcd",23,'1'));
    }

}
