package com.codegym.service.impl;

import com.codegym.model.Note;
import com.codegym.model.NoteType;
import com.codegym.repository.NoteRepository;
import com.codegym.repository.NoteTypeRepository;
import com.codegym.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Page<NoteType> findAll(Pageable pageable) {
        return noteTypeRepository.findAll(pageable);
    }

    @Override
    public NoteType findById(Long id) {
        return noteTypeRepository.findOne(id);
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);
    }

    @Override
    public void remove(Long id) {
        NoteType noteType = noteTypeRepository.findOne(id);
        Iterable<Note> notes = noteRepository.findAllByNoteType(noteType);
        for (Note note: notes) {
            note.setNoteType(null);
            noteRepository.save(note);
        }
        noteTypeRepository.delete(id);
    }
}


