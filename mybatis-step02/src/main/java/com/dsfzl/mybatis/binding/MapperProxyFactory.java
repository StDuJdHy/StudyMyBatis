package com.dsfzl.mybatis.binding;

import com.dsfzl.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author: dsf
 * @description: 映射器代理工厂
 * @date 2024/11/19 下午4:51
 */

public class MapperProxyFactory<T> {

    // 要给哪个接口做代理，需要把该接口传进来
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(mapperInterface,sqlSession);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
