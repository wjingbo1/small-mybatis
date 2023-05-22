package wang.coisini.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @description: 数据源工厂
 * @author: w_jingbo
 * @date: 2023/5/20
 * @Copyright: 博客：http://coisini.wang
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}

