package com.dsfzl.mybatis.test;





import com.alibaba.fastjson.JSON;
import com.dsfzl.mybatis.builder.xml.XMLConfigBuilder;
import com.dsfzl.mybatis.datasource.pooled.PooledConnection;
import com.dsfzl.mybatis.datasource.pooled.PooledDataSource;
import com.dsfzl.mybatis.io.Resources;
import com.dsfzl.mybatis.session.Configuration;
import com.dsfzl.mybatis.session.SqlSession;
import com.dsfzl.mybatis.session.SqlSessionFactory;
import com.dsfzl.mybatis.session.SqlSessionFactoryBuilder;
import com.dsfzl.mybatis.session.defaults.DefaultSqlSession;
import com.dsfzl.mybatis.test.dao.IUserDao;
import com.dsfzl.mybatis.test.po.User;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author: dsf
 * @description:
 * @date 2024/11/25 下午8:27
 */

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        for (int i = 0; i < 50; i++) {
            User user = userDao.queryUserInfoById(1L);
            logger.info("测试结果：{}", JSON.toJSONString(user));
        }
    }

    @Test
    public void test_pooled() throws SQLException, InterruptedException {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis?useUnicode=true");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("123456");
        // 持续获得链接
        while (true){
            Connection connection = pooledDataSource.getConnection();
            System.out.println(connection);
            Thread.sleep(1000);
            connection.close();
        }
    }
}
