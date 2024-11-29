package com.dsfzl.mybatis.session;

import com.dsfzl.mybatis.builder.xml.XMLConfigBuilder;
import com.dsfzl.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author: dsf
 * @description: 构建SqlSessionFactory的工厂
 * @date 2024/11/21 下午8:28
 */

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
       XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
       return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config){
        return new DefaultSqlSessionFactory(config);
    }
}
