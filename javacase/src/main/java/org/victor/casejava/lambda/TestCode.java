package org.victor.casejava.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.victor.casejava.wrapper.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhengcunwen on 2017/4/7.
 */
public class TestCode {

    // list中User对象，取出对象中ID，并返回list,第一种写法
    @Test
    public void getUserIdList1(){
        List<User> list = Lists.newArrayList(
                new User("1","张三"),
                new User("2","李四"),
                new User("3","王五")
        );
        List<String> ids = list.stream().map(item -> item.getId()).collect(Collectors.toList());

        for (String id:ids){
            System.out.println(id);
        }
    }
    // list中User对象，取出对象中ID，并返回list,第二种写法
    @Test
    public void getUserIdList2(){
        List<User> list = Lists.newArrayList(
                new User("1","张三"),
                new User("2","李四"),
                new User("3","王五")
        );
        List<String> ids = list.stream().map(item -> {
            return item.getId();
        }).collect(Collectors.toList());

        for (String id:ids){
            System.out.println(id);
        }
    }

    /**
     * filter列表的应用
     */
    @Test
    public void filter(){
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        // 得到非空元素的数量
        long count = nums.stream().filter(item -> item != null).count();
        // 得到非空元素的新列表
        List<Integer> result = nums.stream().filter(item -> item != null).collect(Collectors.toList());
        System.out.println(count);

        for (Integer id:result){
            System.out.println(id);
        }
    }

    /**
     * 定义stream方式
     */
    @Test
    public void streamTest(){
        // 构造器创建
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
        Stream<String> stringStream = Stream.of("taobao");

        // 数组方式创建
        String[] arr = {"zhagnsan","creek", "program", "creek", "java", "web"};
        Stream<String> arrStream1 = Stream.of(arr);
        Arrays.asList(1,3,4,5,23,2,4);


        List<String> list = Lists.newArrayList("zhagnsan","creek", "program", "creek", "java", "web");
        Stream<String> listStream = list.stream();


        //
    }

}

