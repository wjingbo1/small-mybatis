package wang.coisini.mybatis.builder;

import wang.coisini.mybatis.mapping.ResultMap;
import wang.coisini.mybatis.mapping.ResultMapping;

import java.util.List;

/**
 * @description: 结果映射解析器
 * @author: w_jingbo
 * @date: 2023/8/15
 * @Copyright: 博客：http://coisini.wang
 */
public class ResultMapResolver {

    private final MapperBuilderAssistant assistant;
    private String id;
    private Class<?> type;
    private List<ResultMapping> resultMappings;

    public ResultMapResolver(MapperBuilderAssistant assistant, String id, Class<?> type, List<ResultMapping> resultMappings) {
        this.assistant = assistant;
        this.id = id;
        this.type = type;
        this.resultMappings = resultMappings;
    }

    public ResultMap resolve() {
        return assistant.addResultMap(this.id, this.type, this.resultMappings);
    }

}
