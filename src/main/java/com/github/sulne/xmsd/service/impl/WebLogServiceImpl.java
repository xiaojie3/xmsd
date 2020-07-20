package com.github.sulne.xmsd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.sulne.xmsd.dao.WebLogDao;
import com.github.sulne.xmsd.pojo.WebLog;
import com.github.sulne.xmsd.service.WebLogService;

@Service
public class WebLogServiceImpl implements WebLogService{

	@Resource
	private WebLogDao webLogDao;
	
	@Override
	public void insert(WebLog webLog) {
		// TODO Auto-generated method stub
		webLogDao.insert(webLog);
	}

}
