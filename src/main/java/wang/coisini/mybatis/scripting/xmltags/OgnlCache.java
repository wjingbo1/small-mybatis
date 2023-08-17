package wang.coisini.mybatis.scripting.xmltags;

import ognl.Ognl;
import ognl.OgnlException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: OGNL缓存：http://code.google.com/p/mybatis/issues/detail?id=342
 * @author: w_jingbo
 * @date: 2023/8/16
 * @Copyright: 博客：http://coisini.wang
 */
public class OgnlCache {

    private static final Map<String, Object> expressionCache = new ConcurrentHashMap<String, Object>();

    private OgnlCache() {
        // Prevent Instantiation of Static Class
    }

    public static Object getValue(String expression, Object root) {
        try {
            Map<Object, OgnlClassResolver> context = Ognl.createDefaultContext(root, new OgnlClassResolver());
            return Ognl.getValue(parseExpression(expression), context, root);
        } catch (OgnlException e) {
            throw new RuntimeException("Error evaluating expression '" + expression + "'. Cause: " + e, e);
        }
    }

    private static Object parseExpression(String expression) throws OgnlException {
        Object node = expressionCache.get(expression);
        if (node == null) {
            // OgnlParser.topLevelExpression 操作耗时，加个缓存放到 ConcurrentHashMap 里面
            node = Ognl.parseExpression(expression);
            expressionCache.put(expression, node);
        }
        return node;
    }

}
