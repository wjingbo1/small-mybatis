package wang.coisini.mybatis.parsing;

/**
 * @description: 记号处理器
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public interface TokenHandler {

    String handleToken(String content);

}
