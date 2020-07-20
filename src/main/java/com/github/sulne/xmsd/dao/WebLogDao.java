package com.github.sulne.xmsd.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.github.sulne.xmsd.pojo.WebLog;

@Mapper
public interface WebLogDao {
	
	@Insert("insert into weblog "
			+"values (#{id},#{url},#{method},#{ip},#{type},#{parameters},#{ret},#{time},#{userId},#{cost})")
	void insert(WebLog webLog);
}
