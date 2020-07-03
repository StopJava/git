package com.it.ssm.dao;

import com.it.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    //根据id查询产品信息
    @Select("select * from product where id = #{id}")
    Product findAllById(String id) throws Exception;
    //添加产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)values(#{productNum},#{productName}" +
            ",#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product)throws Exception;
    //查询所有产品信息
    @Select("select * from product")
    List<Product> findAll()throws Exception;
    //根据复选框所选的序号删除产品
    @Delete("delete from product where id = #{id}")
    void deleteById(String id);
}
