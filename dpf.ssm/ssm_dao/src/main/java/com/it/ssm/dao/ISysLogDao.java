package com.it.ssm.dao;

import com.it.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-07-01 14:12
 **/
public interface ISysLogDao {
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method)values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog)throws Exception;
    @Select("select * from syslog")
    List<SysLog> findAll()throws Exception;
}
