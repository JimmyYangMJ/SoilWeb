package com.mvc.service;

import com.mvc.common.ServerResponse;
import com.mvc.pojo.User;

public interface IUserService {

    // Todo 登陆账号
    ServerResponse<User> login(String username, String password);

    // Todo 注册账号

    // Todo 认证账号

    // Todo 注销账号


}
