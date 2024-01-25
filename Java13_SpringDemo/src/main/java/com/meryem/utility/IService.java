package com.meryem.utility;

import java.util.List;
import java.util.Optional;

public interface IService <T,ID>{
    T save(T t);
    T update(T t);
    Iterable<T> saveAll(Iterable<T> t);
    void delete(T t);
    void deleteByID(T t);
    Optional<T> findById(ID id);
    List<T> finALl();
}
