package wang.coisini.mybatis.datasource.pooled;

import wang.coisini.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/5/21
 * @Copyright: 博客：http://coisini.wang
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
