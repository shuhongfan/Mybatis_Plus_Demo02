package com.shf.mybatisplus.service.impl;

import com.shf.mybatisplus.entity.User;
import com.shf.mybatisplus.mapper.UserMapper;
import com.shf.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuhongfan
 * @since 2022-05-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
