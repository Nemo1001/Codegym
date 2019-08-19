package com.codegym.cms.service;

import com.codegym.cms.model.Post;
import com.codegym.cms.repository.PostRepository;
import com.codegym.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    public List<Post> findALl() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.remove(id);
    }
}
