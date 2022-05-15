package com.shf.mymp;

import com.shf.mymp.pojo.User;
import com.shf.mymp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MPServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println(count);
    }

    /**
     * 批量添加
     */
    @Test
    public void testInsert(){
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("ybc"+i);
            user.setAge(20+i*2*i);
            list.add(user);
        }
        boolean result = userService.saveBatch(list);
        System.out.println(result);
    }
}
