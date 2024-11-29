package com.dsfzl.mybatis.builder;


import com.dsfzl.mybatis.session.Configuration;
import com.dsfzl.mybatis.type.TypeAliasRegistry;

/**
 * @author: dsf
 * @description: 构建器的父类，建造者模式
 * @date 2024/11/21 下午8:32
 */

public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration(){
        return configuration;
    }
}
