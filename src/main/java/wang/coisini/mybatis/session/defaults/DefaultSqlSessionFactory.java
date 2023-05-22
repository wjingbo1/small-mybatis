package wang.coisini.mybatis.session.defaults;

import wang.coisini.mybatis.binding.MapperRegistry;
import wang.coisini.mybatis.executor.Executor;
import wang.coisini.mybatis.mapping.Environment;
import wang.coisini.mybatis.session.Configuration;
import wang.coisini.mybatis.session.SqlSession;
import wang.coisini.mybatis.session.SqlSessionFactory;
import wang.coisini.mybatis.session.TransactionIsolationLevel;
import wang.coisini.mybatis.transaction.Transaction;
import wang.coisini.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @description: 默认的 DefaultSqlSessionFactory
 * @author: w_jingbo
 * @date: 2023/5/20
 * @Copyright: 博客：http://coisini.wang
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
