package com.stu.vo;

import com.stu.annotation.controller.UserController;
import com.stu.annotation.dao.UserDao;
import com.stu.annotation.service.UserService;
import com.stu.beanfactory.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.stu.annotation.vo.*;
/**
 * Created by admin on 2018/10/29.
 */
public class AnnotationTest {
    @Test
    public void testAnnotation(){
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationAnnotation.xml");
        /*People person= (People) act.getBean("people");
        System.out.println(person);*/

        UserController userController= (UserController) act.getBean("userController");
        System.out.println(userController);

        UserService userService= (UserService) act.getBean("userService");
        System.out.println(userService);

        UserDao userDao= (UserDao) act.getBean("userDao");
        System.out.println(userDao);


        userController.doInsert();

    }
}
