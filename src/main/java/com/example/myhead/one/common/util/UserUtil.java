package com.example.myhead.one.common.util;

import org.springframework.security.core.context.SecurityContextHolder;
import recruit.entity.sys.User;
import recruit.service.sys.UserService;

public class UserUtil {

    public static User getCurrentUser(UserService userService){
        User user = userService.findUserByAccount(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return user;
    }
}
