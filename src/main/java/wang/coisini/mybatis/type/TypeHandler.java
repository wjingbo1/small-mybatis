package wang.coisini.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description: 类型处理器
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public interface TypeHandler <T>{

    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

}
