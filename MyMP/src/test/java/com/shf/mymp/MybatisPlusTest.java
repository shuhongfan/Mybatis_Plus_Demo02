package com.shf.mymp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shf.mymp.mapper.UserMapper;
import com.shf.mymp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);

        Page<User> userPage = userMapper.selectPage(page, null);

        System.out.println(userPage.getRecords());
        System.out.println(userPage.getPages());
        System.out.println(userPage.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testPageVo(){
//        自定义分页
        Page<User> page = new Page<>(1, 3);
        Page<User> userPage = userMapper.selectPageVo(page, 20);
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getPages());
        System.out.println(userPage.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
