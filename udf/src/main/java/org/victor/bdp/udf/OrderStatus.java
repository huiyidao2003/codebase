package org.victor.bdp.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by zhengcunwen on 2017/7/19.
 */
public class OrderStatus extends UDF {

    public String evaluate(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
       if("0".equals(str)){
            return "not_paid";
       }else if("1".equals(str)){
           return "paid";
       }else if("2".equals(str)){
           return "processed";
       }else if("3".equals(str)){
           return "warehouse_out";
       }else if("4".equals(str)){
           return "logistics_transport";
       }else if("5".equals(str)){
           return "received";
       }else if("6".equals(str)){
           return "completed";
       }else{
           return null;
       }
    }


    //测试的main方法
    public static void main(String[] args) throws Exception{
        OrderStatus fes = new OrderStatus();

        System.out.println(fes.evaluate("1"));
    }
}
