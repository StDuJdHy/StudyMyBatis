package com.dsfzl.mybatis.binding;

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

    private Map<String, String> sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(Class<T> mapperInterface, Map<String, String> sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this, args);
        }else {
            // 这里的sqlSession本来是需要通过解析xml文件得到sql语句，这里先提供一个结构来进行模拟
            return "你被代理了! " + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
