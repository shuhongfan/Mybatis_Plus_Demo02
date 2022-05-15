package com.shf.mymp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.shf.mymp.mapper.UserMapper;
import com.shf.mymp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MPWrapper {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        查询用户名包含a，年龄在20-30之间，邮箱信息不为空的用户信息
        queryWrapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test02() {
//        查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        年龄降序，id升序
        queryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test03() {
//        删除邮箱地址为null的
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");
        int result = userMapper.delete(wrapper);
        System.out.println(result);
    }

    @Test
    public void test04() {
//        将 年龄大于20并且用户名中包含有a 或 邮箱为null的用户的信息修改
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .gt("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("test@dfd.com");
        int result = userMapper.update(user, userQueryWrapper);
        System.out.println(result);
    }


    @Test
    public void test05() {
//        将 年龄大于20 (用户名中包含有a 或 邮箱为null)的用户的信息修改
//        lambade的条件优先执行
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .like("user_name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("小明");
        user.setEmail("test@dfd.com");
        int result = userMapper.update(user, userQueryWrapper);
        System.out.println(result);
    }

    @Test
    public void test06() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        设置要查询的字段
        userQueryWrapper.select("user_name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07() {
//        查询id小于等于100的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        设置子查询
        queryWrapper.inSql("uid", "select uid from t_user where uid<=100");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test08() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper
                .like("user_name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        userUpdateWrapper.set("user_name", "小黑").set("email", "sds@ww.com");
        int result = userMapper.update(null, userUpdateWrapper);
        System.out.println(result);
    }

    @Test
    public void test09() {
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
//            isNotBlank 判断某个字符串是否不为空字符串、不为null、不为空白符
            queryWrapper.like("user_name", username);
        }
        if (ageBegin != null) {
            queryWrapper.ge("age", ageBegin);
        }
        if (ageEnd != null) {
            queryWrapper.le("age", ageEnd);
        }
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test10() {
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test11() {
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test12() {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName, "a")
                .and(i -> i.gt(User::getAge, 20).or().isNull(User::getEmail));
        lambdaUpdateWrapper.set(User::getName, "小鬼").set(User::getEmail, "abcd@ww.coom");
        int result = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println(result);
    }
}
