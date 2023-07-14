package wang.coisini.mybatis.executor;

import wang.coisini.mybatis.executor.statement.StatementHandler;
import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.mapping.MappedStatement;
import wang.coisini.mybatis.session.Configuration;
import wang.coisini.mybatis.session.ResultHandler;
import wang.coisini.mybatis.session.RowBounds;
import wang.coisini.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @description: 简单执行器
 * @author: w_jingbo
 * @date: 2023/5/22
 * @Copyright: 博客：http://coisini.wang
 */
public class SimpleExecutor extends BaseExecutor{

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        try {
            Configuration configuration = ms.getConfiguration();
            // 新建一个 StatementHandler
            StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, rowBounds, resultHandler, boundSql);
            Connection connection = transaction.getConnection();
            // 准备语句
            Statement stmt = handler.prepare(connection);
            handler.parameterize(stmt);
            // 返回结果
            return handler.query(stmt, resultHandler);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
