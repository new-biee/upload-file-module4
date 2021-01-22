package com.uploadfile.demo.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(long id);

    void update(T model);

    void save(T model);

    void remove(Long id);
}
