package wang.coisini.mybatis.scripting.xmltags;

import org.dom4j.Element;
import wang.coisini.mybatis.builder.BaseBuilder;
import wang.coisini.mybatis.mapping.SqlSource;
import wang.coisini.mybatis.scripting.defaults.RawSqlSource;
import wang.coisini.mybatis.session.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: XML脚本构建器
 * @author: w_jingbo
 * @date: 2023/6/12
 * @Copyright: 博客：http://coisini.wang
 */
public class XMLScriptBuilder extends BaseBuilder {


    private Element element;
    private boolean isDynamic;
    private Class<?> parameterType;

    public XMLScriptBuilder(Configuration configuration, Element element, Class<?> parameterType) {
        super(configuration);
        this.element = element;
        this.parameterType = parameterType;
    }

    public SqlSource parseScriptNode() {
        List<SqlNode> contents = parseDynamicTags(element);
        MixedSqlNode rootSqlNode = new MixedSqlNode(contents);
        return new RawSqlSource(configuration, rootSqlNode, parameterType);
    }

    List<SqlNode> parseDynamicTags(Element element) {
        List<SqlNode> contents = new ArrayList<>();
        // element.getText 拿到 SQL
        String data = element.getText();
        contents.add(new StaticTextSqlNode(data));
        return contents;
    }

}
