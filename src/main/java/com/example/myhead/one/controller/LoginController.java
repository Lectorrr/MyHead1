package com.example.myhead.one.controller;

import com.example.myhead.one.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

}
