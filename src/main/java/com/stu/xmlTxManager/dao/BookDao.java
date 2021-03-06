package com.stu.xmlTxManager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by admin on 2018/11/9.
 */
@Repository
public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据书号查询单价
     * @param id
     * @return
     */
    public BigDecimal getPriceById(int id){
        String sql="select price from book where id=?";
        return jdbcTemplate.queryForObject(sql,BigDecimal.class,id);
    }

    /**
     * 减库存
     * @param id
     */
    public void updateSotck(int id){
        String selSql="select num from book_stock where book_id=?";
        int num=jdbcTemplate.queryForObject(selSql,Integer.class,id);
        if (num<1)
            throw new RuntimeException("库存不足:"+id);
        String updSql="update book_stock set num=num-1 where book_id=?";
        jdbcTemplate.update(updSql,id);
        System.out.println("减库存完成:"+id);
    }
}
