package edu.mum.cs.wap.services;

import java.util.List;

public interface IService<T> {

    boolean Create(T model);
    boolean Update (T model);
    //T GetById(int id);
    List<T> GetAll();
}
