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
}
