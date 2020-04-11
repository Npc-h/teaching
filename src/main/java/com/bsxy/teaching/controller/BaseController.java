package com.bsxy.teaching.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName BaseController
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/8
 * @Version V1.0
 **/
@Controller
public class BaseController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/indexAdmin")
    public String indexAdmin(){
        return "index_admin";
    }


}
