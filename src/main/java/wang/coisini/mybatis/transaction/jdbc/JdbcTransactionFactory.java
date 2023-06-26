package wang.coisini.mybatis.transaction.jdbc;

import wang.coisini.mybatis.session.TransactionIsolationLevel;
import wang.coisini.mybatis.transaction.Transaction;
import wang.coisini.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @description: JdbcTransaction 工厂
 * @author: w_jingbo
 * @date: 2023/5/20
 * @Copyright: 博客：http://coisini.wang
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
