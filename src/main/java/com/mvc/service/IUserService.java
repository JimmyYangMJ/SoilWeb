package com.mvc.service;

import com.mvc.common.ServerResponse;
import com.mvc.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String username, String password);
}
