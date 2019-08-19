package com.codegym.cms.service;

import com.codegym.cms.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findById(Long id);

    void save(Post post);

    void remove(Long id);
}