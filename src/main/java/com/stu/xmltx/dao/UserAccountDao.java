package com.stu.xmltx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by admin on 2018/11/9.
 */
@Repository
public class UserAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 更新账户余额
     * @param userId
     * @param price
     */
    public void updateAccount(String userId,BigDecimal price){
        String selSql="select balance from user_account where user_id=?";
        BigDecimal balance=jdbcTemplate.queryForObject(selSql,BigDecimal.class,userId);
        if (-1==balance.compareTo(price))
            throw new RuntimeException("账户余额不足:"+userId);
        String updSql="update user_account set balance=balance-? where user_id=?";
        jdbcTemplate.update(updSql,price,userId);
        System.out.println("更新账户余额:减"+price);
    }
}
