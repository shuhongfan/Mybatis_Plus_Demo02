package com.shf.mymp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shf.mymp.mapper.ProductMapper;
import com.shf.mymp.pojo.Product;
import com.shf.mymp.service.ProductService;
import org.springframework.stereotype.Service;

@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
