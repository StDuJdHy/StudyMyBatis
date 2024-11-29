package com.dsfzl.mybatis.binding;



import com.dsfzl.mybatis.mapping.MappedStatement;
import com.dsfzl.mybatis.mapping.SqlCommandType;
import com.dsfzl.mybatis.session.Configuration;
import com.dsfzl.mybatis.session.SqlSession;

import java.lang.reflect.Method;

/**
 * @author: dsf
 * @description: 映射器方法
 * @date 2024/11/21 下午10:05
 */

public class MapperMethod {

    private final SqlCommand command;

    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration) {
        this.command = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object exectue(SqlSession sqlSession, Object[] args) {
        Object result = null;
        switch (command.getType()) {
            case INSERT:
                break;
            case DELETE:
                break;
            case UPDATE:
                break;
            case SELECT:
                result = sqlSession.selectOne(command.getName(), args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + command.getName());
        }
        return result;
    }

    public static class SqlCommand {
        private final String name;
        private final SqlCommandType type;
        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method){
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement ms = configuration.getMappedStatement(statementName);
            name = ms.getId();
            type = ms.getSqlCommandType();
        }

        public String getName() {
            return name;
        }

        public SqlCommandType getType() {
            return type;
        }
    }
}
