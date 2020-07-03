package com.it.ssm.dao;

import com.it.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-16 16:38
 **/
public interface IMemberDao {
    @Select("select * from member where id =#{id}")
    Member findById(String id) throws Exception;
}
