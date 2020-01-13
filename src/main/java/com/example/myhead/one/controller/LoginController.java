package com.example.myhead.one.controller;

import com.example.myhead.one.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

}
