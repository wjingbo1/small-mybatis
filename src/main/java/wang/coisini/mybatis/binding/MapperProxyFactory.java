package wang.coisini.mybatis.binding;

import wang.coisini.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @description: 映射器代理工厂
 * @author: w_jingbo
 * @date: 2023/5/19
 * @Copyright: 博客：http://coisini.wang
 */
public class MapperProxyFactory<T> {
    
    private final Class<T> mapperInterface;


    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }


}
