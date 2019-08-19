package com.codegym.cms.repository;

import com.codegym.cms.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Locale;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findAllByAuthorContaining(String author, Pageable pageable);
    Iterable<Post> findAllByCategory(Locale.Category post);
}
