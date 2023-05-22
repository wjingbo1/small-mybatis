package wang.coisini.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description: 事务接口
 * @author: w_jingbo
 * @date: 2023/5/20
 * @Copyright: 博客：http://coisini.wang
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;

}
