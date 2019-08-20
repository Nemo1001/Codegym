package com.codegym.service;

import com.codegym.model.Note;
import com.codegym.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page<Note> findAll(Pageable pageable);

    Note findById(Long id);

    void save(Note note);

    void remove(Long id);

    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
    Iterable<Note> findAllByNoteType(NoteType noteType);
}