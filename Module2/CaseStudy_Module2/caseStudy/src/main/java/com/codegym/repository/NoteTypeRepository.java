package com.codegym.repository;

import com.codegym.model.NoteType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  NoteTypeRepository extends PagingAndSortingRepository<NoteType, Long> {

}
