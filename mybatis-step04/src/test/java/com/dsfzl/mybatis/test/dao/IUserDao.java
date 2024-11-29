package com.dsfzl.mybatis.test.dao;


import com.dsfzl.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
