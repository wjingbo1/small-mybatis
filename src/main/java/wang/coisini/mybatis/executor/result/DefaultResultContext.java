package wang.coisini.mybatis.executor.result;

import wang.coisini.mybatis.session.ResultContext;

/**
 * @description: 默认结果上下文
 * @author: w_jingbo
 * @date: 2023/7/12
 * @Copyright: 博客：http://coisini.wang
 */
public class DefaultResultContext implements ResultContext {

    private Object resultObject;
    private int resultCount;

    public DefaultResultContext() {
        this.resultObject = null;
        this.resultCount = 0;
    }

    @Override
    public Object getResultObject() {
        return resultObject;
    }

    @Override
    public int getResultCount() {
        return resultCount;
    }

    public void nextResultObject(Object resultObject) {
        resultCount++;
        this.resultObject = resultObject;
    }

}
