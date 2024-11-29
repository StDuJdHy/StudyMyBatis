package com.dsfzl.mybatis.transaction.jdbc;

import com.dsfzl.mybatis.session.TransactionIsolationLevel;
import com.dsfzl.mybatis.transaction.Transaction;
import com.dsfzl.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author: dsf
 * @description: JdbcTransaction 工厂
 * @date 2024/11/25 下午7:20
 */

public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
