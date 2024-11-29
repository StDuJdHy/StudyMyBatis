package com.dsfzl.mybatis.session;

/**
 * @author: dsf
 * @description:
 * @date 2024/11/20 下午7:49
 */

public interface SqlSessionFactory {

    /**
     *  打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
