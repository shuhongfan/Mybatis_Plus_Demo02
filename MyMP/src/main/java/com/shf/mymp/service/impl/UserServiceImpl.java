package com.shf.mymp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shf.mymp.mapper.UserMapper;
import com.shf.mymp.pojo.User;
import com.shf.mymp.service.UserService;
import org.springframework.stereotype.Service;

@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
