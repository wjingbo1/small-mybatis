package wang.coisini.mybatis.test.dao;

import wang.coisini.mybatis.test.po.Activity;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/8/15
 * @Copyright: 博客：http://coisini.wang
 */
public interface IActivityDao {

    Activity queryActivityById(Long activityId);

    Integer insert(Activity activity);

}
