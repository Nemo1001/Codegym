package com.codegym.cms.service.Impl;

import com.codegym.cms.model.Post;
import com.codegym.cms.repository.PostRepository;
import com.codegym.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Locale;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository blogRepository;


    @Override
    public Page<Post> findAll(java.awt.print.Pageable pageable) {
        return null;
    }

    @Override
    public Page<PostService> findAll(Pageable pageable) {
        return PostRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
        blogRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public Page<Post> findAllByFirstNameContaining(String s, java.awt.print.Pageable pageable) {
        return null;
    }

    @Override
    public Page<Post> findAll() {
        return null;
    }

    @Override
    public Page<Post> findAllByAuthorContaining(String author, Pageable pageable) {
        return blogRepository.findAllByAuthorContaining(author, (java.awt.print.Pageable) pageable);
    }

    @Override
    public Iterable<Post> findAllByCategory(Locale.Category category) {
        return blogRepository.findAllByCategory(category);
    }
}