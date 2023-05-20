package wang.coisini.mybatis.session.defaults;

import wang.coisini.mybatis.binding.MapperRegistry;
import wang.coisini.mybatis.session.SqlSession;
import wang.coisini.mybatis.session.SqlSessionFactory;

/**
 * @description: 默认的 DefaultSqlSessionFactory
 * @author: w_jingbo
 * @date: 2023/5/20
 * @Copyright: 博客：http://coisini.wang
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
