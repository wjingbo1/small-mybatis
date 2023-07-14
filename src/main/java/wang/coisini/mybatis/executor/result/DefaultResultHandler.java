package wang.coisini.mybatis.executor.result;

import wang.coisini.mybatis.reflection.factory.ObjectFactory;
import wang.coisini.mybatis.session.ResultContext;
import wang.coisini.mybatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 默认结果处理器
 * @author: w_jingbo
 * @date: 2023/7/12
 * @Copyright: 博客：http://coisini.wang
 */
public class DefaultResultHandler implements ResultHandler {

    private final List<Object> list;

    public DefaultResultHandler() {
        this.list = new ArrayList<>();
    }

    /**
     * 通过 ObjectFactory 反射工具类，产生特定的 List
     */
    @SuppressWarnings("unchecked")
    public DefaultResultHandler(ObjectFactory objectFactory) {
        this.list = objectFactory.create(List.class);
    }

    @Override
    public void handleResult(ResultContext context) {
        list.add(context.getResultObject());
    }

    public List<Object> getResultList() {
        return list;
    }

}
