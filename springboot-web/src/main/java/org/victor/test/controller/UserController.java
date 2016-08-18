package org.victor.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.victor.test.repository.UserRepository;
import org.victor.test.wrapper.UserWrapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengcunwen on 2016/7/15.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;




    @RequestMapping("/save")
    String save() {
        UserWrapper wrapper = new UserWrapper("刘德华",new BigDecimal("5300"),18,19,1);
        userRepository.save(wrapper);
        return "ok";
    }

    @RequestMapping("/update")
    String update() {
        userRepository.update();
        return "ok";
    }


    @RequestMapping("/count")
    String count(Integer id) {
        return "ok ,result=" + userRepository.getCountByGender(id);
    }
    @RequestMapping("/obj1")
    String getObj(Integer id) {
        String result = "空";
        UserWrapper wrapper = userRepository.getUserById1(id);
        if(wrapper != null){
            result = "ok ,name=" + wrapper.getName() + " salary=" + wrapper.getSalary();
        }
        return result;
    }
    @RequestMapping("/obj2")
    String getObj2(Integer id) {
        String result = "空";
        UserWrapper wrapper = userRepository.getUserById2(id);
        if(wrapper != null){
            result = "ok ,name=" + wrapper.getName() + " salary=" + wrapper.getSalary();
        }
        return result;
    }
    @RequestMapping("/obj3")
    String getObj3(Integer id) {
        String result = "空";
        UserWrapper wrapper = userRepository.getUserById3(id);
        if(wrapper != null){
            result = "ok ,name=" + wrapper.getName() + " salary=" + wrapper.getSalary();
        }
        return result;
    }
    @RequestMapping("/list_in")
    String list_in() {

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(5);

        List<UserWrapper> list = userRepository.getListByIn(ids);


        return String.valueOf(list != null?list.size():null);
    }
    @RequestMapping("/list_in2")
    String list_in2() {

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        List<Map<String,Object>> list = userRepository.getListByIn2(ids);


        return String.valueOf(list != null?list.size():null);
    }


}
