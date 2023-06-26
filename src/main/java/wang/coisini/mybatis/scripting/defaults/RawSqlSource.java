package wang.coisini.mybatis.scripting.defaults;

import wang.coisini.mybatis.builder.SqlSourceBuilder;
import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.mapping.SqlSource;
import wang.coisini.mybatis.scripting.xmltags.DynamicContext;
import wang.coisini.mybatis.scripting.xmltags.SqlNode;
import wang.coisini.mybatis.session.Configuration;

import java.util.HashMap;

/**
 * @description: 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public class RawSqlSource implements SqlSource {


    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }

}
