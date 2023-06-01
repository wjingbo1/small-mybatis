package wang.coisini.mybatis.reflection.wrapper;

import wang.coisini.mybatis.reflection.MetaObject;

/**
 * @description: 对象包装工厂
 * @author: w_jingbo
 * @date: 2023/5/22
 * @Copyright: 博客：http://coisini.wang
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
}
