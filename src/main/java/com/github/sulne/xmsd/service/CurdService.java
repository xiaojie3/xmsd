package com.github.sulne.xmsd.service;

import java.util.List;

import com.github.sulne.xmsd.model.CurdModel;
import com.github.sulne.xmsd.pojo.Limit;

public interface CurdService<M extends CurdModel> {
    void save(M model);

    void delete(String id);

    List<M> list();

    M get(String id);

    List<M> limit(Limit limit);
}
