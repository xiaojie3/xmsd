package com.github.sulne.xmsd.dao;

import java.util.List;

import com.github.sulne.xmsd.model.CurdModel;
import com.github.sulne.xmsd.pojo.Limit;

public interface CurdDao<M extends CurdModel> {
	void insert(M model);

	void update(M model);

	void delete(String id);

	List<M> list();

	M select(String id);

	List<M> limit(Limit limit);
}
