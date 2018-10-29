package com.stu.annotation.controller;

import com.stu.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by admin on 2018/10/29.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void doInsert(){
        userService.save();
        System.out.println("doinsert...");
    }
}
