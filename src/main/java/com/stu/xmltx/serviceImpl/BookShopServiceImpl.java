package com.stu.xmltx.serviceImpl;

import com.stu.xmltx.dao.BookDao;
import com.stu.xmltx.dao.UserAccountDao;
import com.stu.xmltx.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by admin on 2018/11/9.
 */
@Service("bookService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserAccountDao userAccountDao;

    @Override
    public void buyBook() {
        BigDecimal price=bookDao.getPriceById(1);
        userAccountDao.updateAccount("001",price);
        bookDao.updateSotck(1);
    }
}
