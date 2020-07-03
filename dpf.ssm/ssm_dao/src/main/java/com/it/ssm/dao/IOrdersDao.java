package com.it.ssm.dao;

import com.it.ssm.domain.Member;
import com.it.ssm.domain.Orders;
import com.it.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    //查询所有订单
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column="id"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "peopleCount",column="peopleCount"),
            @Result(property = "orderDesc",column="orderDesc"),
            @Result(property = "payType",column="payType"),
            @Result(property = "orderStatus",column="orderStatus"),
            @Result(property = "product",column="productId",javaType= Product.class,one=@One(select="com.it.ssm.dao.IProductDao.findAllById"))
    })
    List<Orders> findAll() throws Exception;
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true,property = "id",column="id"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "peopleCount",column="peopleCount"),
            @Result(property = "orderDesc",column="orderDesc"),
            @Result(property = "payType",column="payType"),
            @Result(property = "orderStatus",column="orderStatus"),
            @Result(property = "product",column="productId",javaType= Product.class,one=@One(select="com.it.ssm.dao.IProductDao.findAllById")),
            @Result(property = "member",column="memberId",javaType = Member.class,one=@One(select ="com.it.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column ="id",javaType = java.util.List.class,many=@Many(select = "com.it.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;
}
