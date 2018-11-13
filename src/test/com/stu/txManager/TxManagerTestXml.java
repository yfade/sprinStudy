package com.stu.txManager;

import com.stu.xmlTxManager.dao.BookDao;
import com.stu.xmlTxManager.dao.UserAccountDao;
import com.stu.xmlTxManager.service.BookShopService;
import com.stu.xmlTxManager.service.TestPropagationService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by pc on 2018/11/11.
 */
public class TxManagerTestXml {
    private ApplicationContext ac;
    private UserAccountDao userAccountDao;
    private BookDao bookDao;
    private BookShopService bookShopService;
    private TestPropagationService testPropagationService;
    {
        ac= new ClassPathXmlApplicationContext("applicationTxManager.xml");
        userAccountDao= (UserAccountDao) ac.getBean("userAccountDao");
        bookDao= (BookDao) ac.getBean("bookDao");
        bookShopService = (BookShopService) ac.getBean("bookShopService");
        testPropagationService= (TestPropagationService) ac.getBean("testPropagationService");
    }

    @Test
    public void test2(){
        testPropagationService.testPropagation("tx001", Arrays.asList(1,2));
    }

    @Test
    public void test(){
        BigDecimal price=bookDao.getPriceById(1);
        System.out.println(price);
        bookDao.updateSotck(1);
        userAccountDao.updateAccount("tx001",new BigDecimal(10));
    }

    @Test
    public void test1(){
        bookShopService.buyBook("tx001",1);
    }
}
