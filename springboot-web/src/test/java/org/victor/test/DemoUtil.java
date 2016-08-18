package org.victor.test;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一些测试类
 * Created by zhengcunwen on 2016/7/19.
 */
public class DemoUtil {

    /**
     * 普通青年写的列表转换小写
     */
    public static void test1(){
        List<String> names = new ArrayList<String>();
        names.add("TaoBao");
        names.add("ThiFubao");

        List<String> lowercaseNames = new ArrayList<String>();
        for (String name : names) {
            lowercaseNames.add(name.toLowerCase());
        }

        for (String name : lowercaseNames) {
            System.out.println(name);
        }
    }

    /**
     * guava写的列表转换小写
     */
    public static void test_guava(){
        List<String> names = new ArrayList<String>();
        names.add("TaoBao");
        names.add("ThiFubao");

        List<String> lowercaseNames = FluentIterable.from(names).transform(new Function<String, String>() {
            @Override
            public String apply(String name) {
                return name.toLowerCase();
            }
        }).toList();



        for (String name : lowercaseNames) {
            System.out.println(name);
        }

    }

    /**
     * lambda写的列表转换小写
     */
    public static void test_lambda(){
        List<String> names = new ArrayList<String>();
        names.add("TaoBao");
        names.add("ThiFubao");

        List<String> lowercaseNames = names.stream().map(name -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());


        for (String name : lowercaseNames) {
            System.out.println(name);
        }
    }


    /**
     * 用stream过滤列表中有null的情况
     */
    public static void test_deleteNull(){
        List<Integer> nums = Lists.newArrayList(1,2,null,3,null,8,null,23);
        long count = nums.stream().filter(num -> num != null).count();

        System.out.println(count);


    }

    public static void test_listToMap(){
        User u1 = new User(1,"张三");
        User u2 = new User(2,"李四");
        User u3 = new User(3,"王五");

        List<User> list = Lists.newArrayList(u1,u2,u3);

        System.out.println(list);

      /*  Map<St>
        for(User u:list){

        }*/

    }

    public static void main(String[] args) {
        //test_guava();
        test_listToMap();

    }
}
