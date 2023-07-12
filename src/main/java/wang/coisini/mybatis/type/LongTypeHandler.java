package wang.coisini.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description: Long类型处理器
 * @author: w_jingbo
 * @date: 2023/6/28
 * @Copyright: 博客：http://coisini.wang
 */
public class LongTypeHandler extends BaseTypeHandler<Long>{

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter);
    }
}
