package com.example.Walletpart2.Walletpart2.Repository;

import java.util.List;

public interface CrudOperations <T>{
    List<T> findAll();
    List<T> saveAll(List<T> toSave);
    T save(T toSave);
    T update(T toDelete);
}
