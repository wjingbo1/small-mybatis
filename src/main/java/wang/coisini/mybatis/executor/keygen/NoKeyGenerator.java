package wang.coisini.mybatis.executor.keygen;

import wang.coisini.mybatis.executor.Executor;
import wang.coisini.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @description: 不用键值生成器
 * @author: w_jingbo
 * @date: 2023/8/16
 * @Copyright: 博客：http://coisini.wang
 */
public class NoKeyGenerator implements KeyGenerator{

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

}
