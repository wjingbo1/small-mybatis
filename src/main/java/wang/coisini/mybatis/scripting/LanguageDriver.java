package wang.coisini.mybatis.scripting;

import org.dom4j.Element;
import wang.coisini.mybatis.executor.parameter.ParameterHandler;
import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.mapping.MappedStatement;
import wang.coisini.mybatis.mapping.SqlSource;
import wang.coisini.mybatis.session.Configuration;

/**
 * @description: 脚本语言驱动
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);

}
