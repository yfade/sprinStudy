package com.stu.annotation.serviceimpl;

import com.stu.annotation.dao.UserDao;
import com.stu.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/10/29.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        userDao.add();
        System.out.println("save...");
    }
}
