package wang.coisini.mybatis.executor;


import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.mapping.MappedStatement;
import wang.coisini.mybatis.session.ResultHandler;
import wang.coisini.mybatis.session.RowBounds;
import wang.coisini.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @description: 执行器
 * @author: w_jingbo
 * @date: 2023/5/22
 * @Copyright: 博客：http://coisini.wang
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    int update(MappedStatement ms, Object parameter) throws SQLException;

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}
