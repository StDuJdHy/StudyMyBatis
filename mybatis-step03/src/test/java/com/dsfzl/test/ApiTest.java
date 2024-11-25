package com.dsfzl.test;

import com.dsfzl.mybatis.io.Resources;
import com.dsfzl.mybatis.session.SqlSession;
import com.dsfzl.mybatis.session.SqlSessionFactory;
import com.dsfzl.mybatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dsfzl.test.dao.IUserDao;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: dsf
 * @description:
 * @date 2024/11/20 下午7:51
 */

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException{
        // 1、获取文件流
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        // 2、获取sqlSession工厂sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 3、开启会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、得到代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 5、通过代理对象调用方法
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}",res);
    }

}
