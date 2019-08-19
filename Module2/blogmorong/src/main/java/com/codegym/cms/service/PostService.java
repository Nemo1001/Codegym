package com.codegym.cms.service;

import com.codegym.cms.model.Post;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Locale;
import org.springframework.data.domain.Pageable;
public interface PostService {
    Page<Post> findAll(Pageable pageable);

    Page<PostService> findAll(Pageable pageable);

    Post findById(Long id);

    void save(Post post);

    void remove(Long id);

    Page<Post> findAllByFirstNameContaining(String s, Pageable pageable);

    Page<Post> findAll();

    Page<Post> findAllByAuthorContaining(String author, Pageable pageable);

    Iterable<Post> findAllByCategory(Locale.Category category);
}