package com.dsfzl.mybatis.transaction;



import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: dsf
 * @description: 事务接口
 * @date 2024/11/25 下午7:04
 */

public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
