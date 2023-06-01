package wang.coisini.mybatis.datasource.unpooled;

import wang.coisini.mybatis.datasource.DataSourceFactory;
import wang.coisini.mybatis.reflection.MetaObject;
import wang.coisini.mybatis.reflection.SystemMetaObject;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @description: 无池化数据源工厂
 * @author: w_jingbo
 * @date: 2023/5/21
 * @Copyright: 博客：http://coisini.wang
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {



    protected DataSource dataSource;

    @Override
    public void setProperties(Properties props) {
        MetaObject metaObject = SystemMetaObject.forObject(dataSource);
        for (Object key : props.keySet()) {
            String propertyName = (String) key;
            if (metaObject.hasSetter(propertyName)) {
                String value = (String) props.get(propertyName);
                Object convertedValue = convertValue(metaObject, propertyName, value);
                metaObject.setValue(propertyName, convertedValue);
            }
        }
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 根据setter的类型,将配置文件中的值强转成相应的类型
     */
    private Object convertValue(MetaObject metaObject, String propertyName, String value) {
        Object convertedValue = value;
        Class<?> targetType = metaObject.getSetterType(propertyName);
        if (targetType == Integer.class || targetType == int.class) {
            convertedValue = Integer.valueOf(value);
        } else if (targetType == Long.class || targetType == long.class) {
            convertedValue = Long.valueOf(value);
        } else if (targetType == Boolean.class || targetType == boolean.class) {
            convertedValue = Boolean.valueOf(value);
        }
        return convertedValue;
    }
}
