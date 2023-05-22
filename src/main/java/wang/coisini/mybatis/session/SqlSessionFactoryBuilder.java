package wang.coisini.mybatis.session;

import wang.coisini.mybatis.builder.xml.XMLConfigBuilder;
import wang.coisini.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @description: 构建SqlSessionFactory的工厂
 * @author: w_jingbo
 * @date: 2023/5/20
 * @Copyright: 博客：http://coisini.wang
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
