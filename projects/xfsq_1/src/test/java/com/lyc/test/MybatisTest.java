package com.lyc.test;

import com.lyc.bean.Resident;
import com.lyc.dao.ResidentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


public class MybatisTest {
    public static void main(String[] args)throws Exception {
//        //1.读取配置文件
//        InputStream in = Resources.getResourceAsStream("Mybatis.xml");
//        //2.创建 SqlSessionFactory 的构建者对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        //3.使用构建者创建工厂对象 SqlSessionFactory
//        SqlSessionFactory factory = builder.build(in);
//        //4.使用 SqlSessionFactory 生产 SqlSession 对象
//        SqlSession session = factory.openSession();
//        //5.使用 SqlSession 创建 dao 接口的代理对象
//        ResidentMapper residentMapper = session.getMapper(ResidentMapper.class);
//        // 6.使用代理对象执行查询所有方法
//        Resident r = residentMapper.findOne("123");
//        System.out.println(r);
//        session.close();
//        in.close();
    }

}
