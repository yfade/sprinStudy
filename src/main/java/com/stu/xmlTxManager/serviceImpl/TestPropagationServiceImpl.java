package com.stu.xmlTxManager.serviceImpl;

import com.stu.xmlTxManager.service.BookShopService;
import com.stu.xmlTxManager.service.TestPropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pc on 2018/11/13.
 */
@Service("testPropagationService")
public class TestPropagationServiceImpl implements TestPropagationService {
    @Autowired
    private BookShopService bookShopService;

    @Override
    public void testPropagation(String userId, List<Integer> bookIds){
        for(Integer id:bookIds){
            bookShopService.buyBook(userId,id);
        }
    }
}
