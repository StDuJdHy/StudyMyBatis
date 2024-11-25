package com.dsfzl.mybatis.session.defaults;

import com.dsfzl.mybatis.binding.MapperRegistry;
import com.dsfzl.mybatis.mapping.MappedStatement;
import com.dsfzl.mybatis.session.Configuration;
import com.dsfzl.mybatis.session.SqlSession;

/**
 * @author: dsf
 * @description:
 * @date 2024/11/20 下午7:47
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type,this);
    }

    @Override
    public Configuration getConfiuration() {
        return configuration;
    }


}
