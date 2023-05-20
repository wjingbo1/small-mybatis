package wang.coisini.mybatis.session;

/**
 * @description:  工厂模式接口，构建SqlSession的工厂
 * @author: w_jingbo
 * @date: 2023/5/20
 * @Copyright: 博客：http://coisini.wang
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
