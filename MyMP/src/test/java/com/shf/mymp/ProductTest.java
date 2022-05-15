package com.shf.mymp;

import com.shf.mymp.mapper.ProductMapper;
import com.shf.mymp.pojo.Product;
import com.shf.mymp.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testProduct01(){
        Product productLi = productService.getById(1);
        System.out.println("小李查询的价格："+productLi.getPrice());

        Product productWang = productService.getById(1);
        System.out.println("小王查询的价格："+productWang.getPrice());

        productLi.setPrice(productLi.getPrice()+50);
        productService.updateById(productLi);

        productWang.setPrice(productWang.getPrice()-30);
        boolean result = productService.updateById(productWang);
        if (result==false){
//            操作失败，重试
            Product product = productService.getById(1);
            product.setPrice(product.getPrice()-30);
            productService.updateById(product);
        }

        Product productBoss = productService.getById(1);
        System.out.println("老板查询的价格："+productBoss.getPrice());
    }
}
