package com.vish.springmaven.repository;

import java.util.List;

public interface DataRepository<T> {

    void store(T t);

    T retrieve(int id);

    T search(String name);

    T delete(int id);

    List<T> getAll();

    void update(T t);
}
