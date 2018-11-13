package com.stu.xmlTxManager.serviceImpl;

import com.stu.xmlTxManager.dao.BookDao;
import com.stu.xmlTxManager.dao.UserAccountDao;
import com.stu.xmlTxManager.service.BookShopService;
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

    @Override
    public void buyBook(String userId,Integer bookId) {
        BigDecimal price = bookDao.getPriceById(1);
        bookDao.updateSotck(1);
        userAccountDao.updateAccount("tx001", price);
    }
}
