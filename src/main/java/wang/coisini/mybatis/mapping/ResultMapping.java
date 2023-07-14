package wang.coisini.mybatis.mapping;

import wang.coisini.mybatis.session.Configuration;
import wang.coisini.mybatis.type.JdbcType;
import wang.coisini.mybatis.type.TypeHandler;

/**
 * @description: 结果映射
 * @author: w_jingbo
 * @date: 2023/7/12
 * @Copyright: 博客：http://coisini.wang
 */
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }

}
