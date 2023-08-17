package wang.coisini.mybatis.test.plugin;



import wang.coisini.mybatis.executor.statement.StatementHandler;
import wang.coisini.mybatis.mapping.BoundSql;
import wang.coisini.mybatis.plugin.Interceptor;
import wang.coisini.mybatis.plugin.Intercepts;
import wang.coisini.mybatis.plugin.Invocation;
import wang.coisini.mybatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class TestPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取StatementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        // 获取SQL信息
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        // 输出SQL
        System.out.println("拦截SQL：" + sql);
        // 放行
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("参数输出：" + properties.getProperty("test00"));
    }

}
