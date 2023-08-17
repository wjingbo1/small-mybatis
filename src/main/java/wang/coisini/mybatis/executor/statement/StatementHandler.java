package wang.coisini.mybatis.executor.statement;

import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @description: 语句处理器
 * @author: w_jingbo
 * @date: 2023/5/22
 * @Copyright: 博客：http://coisini.wang
 */
public interface StatementHandler {

    /** 准备语句 */
    Statement prepare(Connection connection) throws SQLException;

    /** 参数化 */
    void parameterize(Statement statement) throws SQLException;

    /** 执行更新 */
    int update(Statement statement) throws SQLException;

    /** 执行查询 */
    <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;

    /** 获取绑定SQL */
    BoundSql getBoundSql();

}
