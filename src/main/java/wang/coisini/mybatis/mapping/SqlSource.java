package wang.coisini.mybatis.mapping;

/**
 * @description: SQL源码
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}
