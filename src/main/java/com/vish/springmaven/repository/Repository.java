package com.vish.springmaven.repository;

public interface Repository<T> {

    void store(T t);

    T retrieve(int id);

    T search(String name);

    T delete(int id);
}