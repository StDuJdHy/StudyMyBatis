package com.dsfzl.mybatis.binding;

import com.dsfzl.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: dsf
 * @description: 映射器代理类
 * @date 2024/11/19 下午4:52
 */

public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -6424540398559729838L;

    private SqlSession sqlSession;
    private final Class<T> mapperInterface;
    private final Map<Method, MapperMethod> methodCache;

    public MapperProxy(Class<T> mapperInterface, Map<Method, MapperMethod> methodCache, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.methodCache = methodCache;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            // 这里的sqlSession本来是需要通过解析xml文件得到sql语句，这里先提供一个结构来进行模拟
            final MapperMethod mapperMethod = cachedMapperMethod(method);
            return mapperMethod.exectue(sqlSession, args);
        }
    }

    private MapperMethod cachedMapperMethod(Method method) {
        MapperMethod mapperMethod = methodCache.get(method);
        if (mapperMethod == null) {
            mapperMethod = new MapperMethod(mapperInterface, method, sqlSession.getConfiuration());
            methodCache.put(method, mapperMethod);
        }
        return mapperMethod;
    }
}
