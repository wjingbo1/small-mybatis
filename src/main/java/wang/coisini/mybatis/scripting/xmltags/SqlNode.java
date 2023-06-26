package wang.coisini.mybatis.scripting.xmltags;

/**
 * @description: SQL 节点
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public interface SqlNode {

    boolean apply(DynamicContext context);

}
