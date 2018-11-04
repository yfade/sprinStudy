package com.stu.aop;

import com.stu.aop.service.CalculateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Created by admin on 2018/11/4.
 */
public class AopTest {
    private Log logger= LogFactory.getLog(this.getClass());

    @Test
    public void  testAop(){
        ApplicationContext act= new ClassPathXmlApplicationContext("applicationAop.xml");
        CalculateService calculate= (CalculateService) act.getBean("calculateService");
        int addRes=calculate.add(1,2);
        System.out.println("add result:"+addRes);

        int subRes=calculate.sub(2,1);
        System.out.println("sub result:"+subRes);

        System.out.println("mul result:"+calculate.mul(2,3));

        System.out.println("div result:"+calculate.div(3,0));
    }

    /**
     * 测试AOP优先级
     */
    @Test
    public void  testAopOrder(){
        ApplicationContext act= new ClassPathXmlApplicationContext("applicationAop.xml");
        CalculateService calculate= (CalculateService) act.getBean("calculateService");
        calculate.testOrder(1,2);
    }
}
