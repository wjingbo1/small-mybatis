package wang.coisini.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description: String类型处理器
 * @author: w_jingbo
 * @date: 2023/6/28
 * @Copyright: 博客：http://coisini.wang
 */
public class StringTypeHandler extends BaseTypeHandler<String>{

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter);
    }

}
