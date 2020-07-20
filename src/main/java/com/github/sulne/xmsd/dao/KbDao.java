package com.github.sulne.xmsd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.sulne.xmsd.pojo.Kb;

@Mapper
public interface KbDao {

	@Select("select jx0404.jx0404id,"
+"       jx02.kch,"
+"       jx02.kcmc,"
+"       jx0408.kkzcmx,"
+"       jx0408.kcsj,"
+"       jx0601.jsmc"
+"  from jx0404"
+" inner join jx0405"
+"    on jx0404.jx0404id = jx0405.jx0404id"
+" inner join jx0408"
+"    on jx0405.jx0405id = jx0408.jx0405id"
+" inner join jx0501"
+"    on jx0404.jx0404id = jx0501.jx0404id"
+" inner join xs0101"
+"    on jx0501.xs0101id = xs0101.xs0101id"
+" inner join jx02"
+"    on jx0404.kcid = jx02.jx02id"
+"  left join jx0601"
+"    on jx0408.jsid = jx0601.jsid"
+" where jx0501.sfxz = '1'"
+"   and xs0101.xh = #{xh}"
+"   and jx0404.xnxq01id = #{xnxq}")
	List<Kb> getkb(@Param("xnxq") String xnxq,@Param("xh")  String xh);
}
