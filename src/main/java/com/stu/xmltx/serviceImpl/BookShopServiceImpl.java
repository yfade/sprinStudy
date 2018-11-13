package com.stu.xmltx.serviceImpl;

import com.stu.xmltx.dao.BookDao;
import com.stu.xmltx.dao.UserAccountDao;
import com.stu.xmltx.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by admin on 2018/11/9.
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserAccountDao userAccountDao;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void buyBook(String userId,Integer bookId) {
        BigDecimal price = bookDao.getPriceById(1);
        userAccountDao.updateAccount("tx001", price);
        bookDao.updateSotck(1);
    }
}
