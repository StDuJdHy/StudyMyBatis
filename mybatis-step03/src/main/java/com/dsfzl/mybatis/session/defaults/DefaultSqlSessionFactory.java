package com.dsfzl.mybatis.session.defaults;

import com.dsfzl.mybatis.binding.MapperRegistry;
import com.dsfzl.mybatis.session.Configuration;
import com.dsfzl.mybatis.session.SqlSession;
import com.dsfzl.mybatis.session.SqlSessionFactory;

/**
 * @author: dsf
 * @description:
 * @date 2024/11/20 下午7:50
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
