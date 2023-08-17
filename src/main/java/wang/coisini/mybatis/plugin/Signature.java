package wang.coisini.mybatis.plugin;

/**
 * @description: 方法签名
 * @author: w_jingbo
 * @date: 2023/8/17
 * @Copyright: 博客：http://coisini.wang
 */
public @interface Signature {

    /**
     * 被拦截类
     */
    Class<?> type();

    /**
     * 被拦截类的方法
     */
    String method();

    /**
     * 被拦截类的方法的参数
     */
    Class<?>[] args();

}
