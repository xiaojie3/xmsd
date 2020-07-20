package com.github.sulne.xmsd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.sulne.xmsd.dao.CurdDao;
import com.github.sulne.xmsd.model.CurdModel;
import com.github.sulne.xmsd.pojo.Limit;
import com.github.sulne.xmsd.service.CurdService;

public abstract class CurdServiceImpl<D extends CurdDao<M>,M extends CurdModel> implements CurdService<M>{

    @Autowired
    protected D dao;

    @Override
    public void save(M model) {
        if (null == model.getId() || null == dao.select(model.getId())) {
            dao.insert(model);
        } else {
            // 如果ID不为而且有数据，则进行更新
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        dao.delete(id);
    }

    @Override
    public M get(String id) {
        // TODO Auto-generated method stub
        return dao.select(id);
    }

    @Override
    public List<M> list() {
        // TODO Auto-generated method stub
        return dao.list();
    }

    public List<M> limit(Limit limit) {
        return dao.limit(limit);
    }
}
