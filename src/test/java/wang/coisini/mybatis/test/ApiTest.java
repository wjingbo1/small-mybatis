package wang.coisini.mybatis.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wang.coisini.mybatis.binding.MapperRegistry;
import wang.coisini.mybatis.session.SqlSession;
import wang.coisini.mybatis.session.SqlSessionFactory;
import wang.coisini.mybatis.session.defaults.DefaultSqlSessionFactory;
import wang.coisini.mybatis.test.dao.IUserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/5/19
 * @Copyright: 博客：http://coisini.wang
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("wang.coisini.mybatis.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }
}
