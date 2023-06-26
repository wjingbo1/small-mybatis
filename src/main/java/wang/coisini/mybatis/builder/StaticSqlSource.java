package wang.coisini.mybatis.builder;

import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.mapping.ParameterMapping;
import wang.coisini.mybatis.mapping.SqlSource;
import wang.coisini.mybatis.session.Configuration;

import java.util.List;

/**
 * @description: 静态SQL源码
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }
}
