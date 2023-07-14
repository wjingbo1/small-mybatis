package wang.coisini.mybatis.session.defaults;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wang.coisini.mybatis.binding.MapperRegistry;
import wang.coisini.mybatis.executor.Executor;
import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.mapping.Environment;
import wang.coisini.mybatis.mapping.MappedStatement;
import wang.coisini.mybatis.session.Configuration;
import wang.coisini.mybatis.session.RowBounds;
import wang.coisini.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 默认SqlSession实现类
 * @author: w_jingbo
 * @date: 2023/5/20
 * @Copyright: 博客：http://coisini.wang
 */
public class DefaultSqlSession implements SqlSession {

    private Logger logger = LoggerFactory.getLogger(DefaultSqlSession.class);

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        logger.info("执行查询 statement：{} parameter：{}", statement, JSON.toJSONString(parameter));
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER, ms.getSqlSource().getBoundSql(parameter));
        return list.get(0);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
