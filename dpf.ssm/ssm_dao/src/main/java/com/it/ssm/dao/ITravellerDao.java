package com.it.ssm.dao;

import com.it.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-16 17:30
 **/
public interface ITravellerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersid})")
    List<Traveller> findByOrdersId(String ordersid) throws Exception;
}
