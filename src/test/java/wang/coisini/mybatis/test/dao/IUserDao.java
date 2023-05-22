package wang.coisini.mybatis.test.dao;

import wang.coisini.mybatis.test.po.User;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/5/19
 * @Copyright: 博客：http://coisini.wang
 */
public interface IUserDao {
    String queryUserName(String username);

    Integer queryUserAge(String uId);

    User queryUserInfoById(Long uId);
}
