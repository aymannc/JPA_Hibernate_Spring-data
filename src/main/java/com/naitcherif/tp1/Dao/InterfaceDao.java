package com.naitcherif.tp1.Dao;

import java.util.List;

public interface InterfaceDao<E> {
    E save(E p);

    List<E> findAll();

    E findOne(Long id);

    void remove(Long id);

    void update(E p);

    List<E> findByDesignation(String des);
}
