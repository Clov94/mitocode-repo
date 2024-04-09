package com.mitocode.repo.Service;

import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICRUD<T> {
    T save(T t);
    T update(T t);
    List<T> findAll();
}
