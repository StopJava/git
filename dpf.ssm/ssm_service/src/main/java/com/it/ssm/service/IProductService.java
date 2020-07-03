package com.it.ssm.service;

import com.it.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    //添加产品
    void save(Product product)throws Exception;
    //查询全部产品
    List<Product> findAll(int page, int size)throws Exception;
    //删除复选框中的产品
    void deleteById(String id);
}
