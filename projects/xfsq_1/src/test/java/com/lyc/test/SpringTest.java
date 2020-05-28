package com.lyc.test;

import com.lyc.bean.ActiveMan;
import com.lyc.bean.PageParams;
import com.lyc.bean.Resident;
import com.lyc.dao.ResidentMapper;
import com.lyc.service.ActiveService;
import com.lyc.service.ResidentService;
import com.lyc.service.serviceImpl.ActiveServiceImpl;
import com.lyc.service.serviceImpl.ResidentServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {
    @Test
    public void test  () {
        /*//获取applicationContext文件并加载
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //获取StudentDao的bean
        ActiveServiceImpl activeService= (ActiveServiceImpl) ac.getBean("activeService");
        PageParams pageParams=new PageParams();
        pageParams.setPageNo(1);
        pageParams.getPageSize(2);
        List<ActiveMan> list=activeService.selectAllman(pageParams);
        for (ActiveMan a:list
             ) {
            System.out.println(a);
        }*/

    }
}

