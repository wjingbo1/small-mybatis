package wang.coisini.mybatis.session;

/**
 * @description: 本地缓存机制；
 * SESSION 默认值，缓存一个会话中执行的所有查询
 * STATEMENT 本地会话仅用在语句执行上，对相同 SqlSession 的不同调用将不做数据共享
 * @author: w_jingbo
 * @date: 2023/8/17
 * @Copyright: 博客：http://coisini.wang
 */
public enum LocalCacheScope {

    SESSION,
    STATEMENT

}
