package com.stu.tx;

import com.stu.annotation.dao.UserDao;
import com.stu.xmltx.dao.BookDao;
import com.stu.xmltx.dao.UserAccountDao;
import com.stu.xmltx.service.BookShopService;
import com.stu.xmltx.vo.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * Created by pc on 2018/11/11.
 */
public class TxTestXml {
    private ApplicationContext ac;
    private UserAccountDao userAccountDao;
    private BookDao bookDao;
    private BookShopService bookShopService;
    {
        ac= new ClassPathXmlApplicationContext("applicationTx.xml");
        userAccountDao= (UserAccountDao) ac.getBean("userAccountDao");
        bookDao= (BookDao) ac.getBean("bookDao");
        bookShopService = (BookShopService) ac.getBean("bookShopService");
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
        bookShopService.buyBook();
    }
}
