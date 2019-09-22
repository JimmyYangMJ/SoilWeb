package com.mvc.service.impl;

//import com.mmall.common.Const;

import com.mvc.common.ServerResponse;
import com.mvc.dao.UserMapper;
import com.mvc.pojo.User;
import com.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by geely
 */
@Service("iUserService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if(resultCount == 0 ){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //todo 密码登陆
//        String md5Password = MD5Util.MD5EncodeUtf8(password);
//        User user  = userMapper.selectLogin(username,md5Password);
        User user  = userMapper.selectLogin(username,password);
        if(user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccess("登录成功",user);
    }


}
