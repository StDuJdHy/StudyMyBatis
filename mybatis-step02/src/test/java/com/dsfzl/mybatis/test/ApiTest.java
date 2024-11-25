package com.dsfzl.mybatis.test;

import com.dsfzl.mybatis.binding.MapperRegistry;
import com.dsfzl.mybatis.session.SqlSession;
import com.dsfzl.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.dsfzl.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: dsf
 * @description:
 * @date 2024/11/20 下午7:51
 */

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.dsfzl.mybatis.test.dao");

        // 2. 从 SqlSession 工厂获取 session
        DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
        System.out.println();

    }

}
