package com.it.ssm.service.impl;

import com.it.ssm.dao.ISysLogDao;
import com.it.ssm.domain.SysLog;
import com.it.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-07-01 14:10
 **/
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
