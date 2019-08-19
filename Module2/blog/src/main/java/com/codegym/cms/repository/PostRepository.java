package com.codegym.cms.repository;

import com.codegym.cms.model.Post;

import java.util.List;

public interface PostRepository<T>{

    List<T> findAll();

    Post findById(Long id);

    void save(T model);

    void save(Post model);

    void remove(Long id);
}
