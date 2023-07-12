package wang.coisini.mybatis.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description: 参数处理器
 * @author: w_jingbo
 * @date: 2023/6/28
 * @Copyright: 博客：http://coisini.wang
 */
public interface ParameterHandler {

    /**
     * 获取参数
     */
    Object getParameterObject();

    /**
     * 设置参数
     */
    void setParameters(PreparedStatement ps) throws SQLException;

}
