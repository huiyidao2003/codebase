package org.victor.test.shirotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录操作类
 */
@Controller
public class LoginController {

    /**
     * 首页跳转
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }


    /**
     * 登录页面跳转
     * @return
     */
    public String login(){
        return "login";
    }

    public String toLogin(){
        return "toLogin";
    }
}
