package wang.coisini.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @description: getter 调用者
 * @author: w_jingbo
 * @date: 2023/5/22
 * @Copyright: 博客：http://coisini.wang
 */
public class GetFieldInvoker implements Invoker {

    private Field field;

    // 获取对象的成员变量并保存到Field中
    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    //获取成员变量的值
    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    //返回成员变量的类型
    @Override
    public Class<?> getType() {
        return field.getType();
    }

}
