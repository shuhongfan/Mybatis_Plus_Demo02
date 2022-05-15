package com.shf.mymp;

import com.shf.mymp.mapper.UserMapper;
import com.shf.mymp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MPTest {
    @Autowired
    public UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("shbdh@fs.c");
        int result = userMapper.insert(user);

        System.out.println(user);
        System.out.println("result:"+result);
    }

    @Test
    public void testDelete(){
        int result = userMapper.deleteById(1525418878740475906L);
        System.out.println(result);
    }

    /**
     * 根据map集合中所设置的条件进行删除
     */
    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        int result = userMapper.deleteByMap(map);
        System.out.println("result:"+result);
    }

    @Test
    public void testDeleteBatchIds(){
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println(result);
    }


    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setName("李斯");
        user.setEmail("lll@23.com");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    /**
     * 通过id查询用户信息
     */
    @Test
    public void testSelect(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds(){
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    /**
     * 根据map集合的条件查询
     */
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "jack");
        map.put("age", 20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void selectMapById(){
        Map<String, Object> map = userMapper.selectMapById(1L);

        System.out.println(map);

    }

}
