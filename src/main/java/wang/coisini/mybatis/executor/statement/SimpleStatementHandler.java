package wang.coisini.mybatis.executor.statement;

import wang.coisini.mybatis.executor.Executor;
import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.mapping.MappedStatement;
import wang.coisini.mybatis.session.ResultHandler;
import wang.coisini.mybatis.session.RowBounds;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @description: 简单语句处理器（STATEMENT）
 * @author: w_jingbo
 * @date: 2023/5/22
 * @Copyright: 博客：http://coisini.wang
 */
public class SimpleStatementHandler extends BaseStatementHandler {

    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, rowBounds, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        // N/A
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return resultSetHandler.handleResultSets(statement);
    }

}
