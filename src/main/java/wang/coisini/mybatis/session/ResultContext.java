package wang.coisini.mybatis.session;

/**
 * @description: 结果上下文
 * @author: w_jingbo
 * @date: 2023/7/12
 * @Copyright: 博客：http://coisini.wang
 */
public interface ResultContext {

    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();

}
