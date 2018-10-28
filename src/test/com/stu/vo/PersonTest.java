package com.stu.vo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.stu.beanfactory.*;
import com.stu.livecycle.*;
import com.stu.livecycle.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/10/27.
 */
public class PersonTest {
    private ApplicationContext act;

    @Before
    public void setUp() throws Exception {
        if (null == act) {
            act = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("end....");
    }

    @Test
    public void getPersonInfo() throws Exception {
        Person person = (Person) act.getBean("person");
        System.out.println(person);
    }


    /**
     * 引入外部文件
     * @throws SQLException
     */
    @Test
    public void testPeizhiwenjian() throws SQLException {
        DataSource dataSource = (DataSource) act.getBean("dataSource");
        System.out.println(dataSource.getConnection());
        ComboPooledDataSource source= (ComboPooledDataSource) act.getBean("dataSource");
        System.out.println(source.getPassword());

    }
    /**
     * SpEL使用
     */
    @Test
    public void testSpEL(){
        act = new ClassPathXmlApplicationContext("applicationSpEl.xml");
        Person person= (Person) act.getBean("person");
        System.out.println(person);
    }

    @Test
    public void testCycle(){
        ClassPathXmlApplicationContext act=new ClassPathXmlApplicationContext("applicationCycle.xml");
        com.stu.livecycle.Car car= (com.stu.livecycle.Car) act.getBean("car");
        System.out.println(car);
        act.close();
    }

    @Test
    public void testFactory(){
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationFactory.xml");
        com.stu.beanfactory.Car car= (com.stu.beanfactory.Car) act.getBean("car");
        System.out.println(car);

        com.stu.beanfactory.Car car1= (com.stu.beanfactory.Car) act.getBean("car1");
        System.out.println(car1);
    }
}