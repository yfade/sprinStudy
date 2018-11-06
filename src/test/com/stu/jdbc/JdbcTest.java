package com.stu.jdbc;

import com.stu.jdbc.po.Depart;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2018/11/6.
 */
public class JdbcTest {
    private ApplicationContext ac;
    private JdbcTemplate jdbcTemplate;
    {
        ac=new ClassPathXmlApplicationContext("applicationJdbc.xml");
        jdbcTemplate= (JdbcTemplate) ac.getBean("jdbcTemplate");
    }

    /**
     * 测试数据库连接
     * @throws SQLException
     */
    @Test
    public void testJdbc() throws SQLException {
        DataSource dataSource= (DataSource) ac.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

    /**
     * 批量插入
     */
    @Test
    public void testBatchInsert(){
        String sql="insert into depart values(NULL,?)";
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{"开发"});
        list.add(new Object[]{"测试"});
        list.add(new Object[]{"实施"});
        jdbcTemplate.batchUpdate(sql,list);
    }

    /**
     * 单个插入
     */
    @Test
    public void testInsert(){
        String sql="insert into depart values(NULL,?)";
        jdbcTemplate.update(sql,new Object[]{"人事"});
    }

    /**
     * 删除
     */
    @Test
    public void testDel(){
        String sql="delete from depart where id=?";
        jdbcTemplate.update(sql,4);
    }

    /**
     * 修改
     */
    @Test
    public void testUpdate(){
        String sql="update depart set name=? where id=?";
        jdbcTemplate.update(sql,"人事",3);
    }

    /**
     * 查询list
     * 1、可以通过别名映射
     * 2、通过RowMapper指定列名和类属性的映射
     * 3、不支持级联
     */
    @Test
    public void testQueryList(){
        String sql="select id,name from depart";
        RowMapper<Depart> rowMapper=new BeanPropertyRowMapper<>(Depart.class);
        List<Depart> list=jdbcTemplate.query(sql,rowMapper);
        System.out.println(list);
    }

    /**
     * 单个查询
     */
    @Test
    public void testQuert(){
        String sql="select * from depart where id=?";
        RowMapper<Depart> rowMapper=new BeanPropertyRowMapper<>(Depart.class);
        Depart depart=jdbcTemplate.queryForObject(sql,rowMapper,3);
        System.out.println(depart);
    }
}
