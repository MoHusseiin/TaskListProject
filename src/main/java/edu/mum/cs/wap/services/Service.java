package edu.mum.cs.wap.services;

import java.util.List;

public class Service<T> implements IService<T> {
    @Override
    public boolean Create(T model) {
        return false;
    }

    @Override
    public boolean Update(T model) {
        return false;
    }

    @Override
    public T GetById(int id) {
        return null;
    }

    @Override
    public List<T> GetAll() {
        return null;
    }
}
