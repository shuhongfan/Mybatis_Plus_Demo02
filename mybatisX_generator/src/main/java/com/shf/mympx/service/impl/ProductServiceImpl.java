package com.shf.mympx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shf.mympx.pojo.Product;
import com.shf.mympx.service.ProductService;
import com.shf.mympx.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author shuho
* @description 针对表【t_product】的数据库操作Service实现
* @createDate 2022-05-14 22:15:23
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




