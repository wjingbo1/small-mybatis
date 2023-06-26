package wang.coisini.mybatis.scripting;

import org.dom4j.Element;
import wang.coisini.mybatis.mapping.SqlSource;
import wang.coisini.mybatis.session.Configuration;

/**
 * @description: 脚本语言驱动
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public interface LanguageDriver {

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

}
