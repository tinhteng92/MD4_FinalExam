package com.codegym.service;

import java.util.List;

public interface IService <E>{
    List<E> getAll();
    void save(E e);
}
