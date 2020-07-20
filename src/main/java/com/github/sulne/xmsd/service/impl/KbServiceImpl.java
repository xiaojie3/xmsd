package com.github.sulne.xmsd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.sulne.xmsd.dao.KbDao;
import com.github.sulne.xmsd.pojo.Kb;
import com.github.sulne.xmsd.service.KbService;

@Service
public class KbServiceImpl implements KbService{
	
	@Resource
	private KbDao kbDao;

	@Override
	public List<Kb> getkb(String xnxq, String xh) {
		// TODO Auto-generated method stub
		return kbDao.getkb(xnxq, xh);
	}

}
