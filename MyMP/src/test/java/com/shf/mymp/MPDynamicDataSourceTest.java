package com.shf.mymp;

import com.shf.mymp.service.ProductService;
import com.shf.mymp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MPDynamicDataSourceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void testDynamicDataSource(){
        System.out.println(userService.getById(1L));
        System.out.println(productService.getById(1L));
    }
}
