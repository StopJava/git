package com.it.ssm.service;

import com.it.ssm.domain.SysLog;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-07-01 14:09
 **/
public interface ISysLogService {
    void save(SysLog sysLog)throws Exception;

    List<SysLog> findAll()throws Exception;
}
