package com.dsfzl.mybatis.session.defaults;

import com.dsfzl.mybatis.binding.MapperRegistry;
import com.dsfzl.mybatis.session.SqlSession;

/**
 * @author: dsf
 * @description:
 * @date 2024/11/20 下午7:47
 */

public class DefaultSqlSession implements SqlSession {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type,this);
    }
}
