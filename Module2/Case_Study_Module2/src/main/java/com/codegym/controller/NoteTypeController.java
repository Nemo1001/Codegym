package com.codegym.controller;


import com.codegym.model.Note;
import com.codegym.model.NoteType;
import com.codegym.service.NoteService;
import com.codegym.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/noteType")
public class NoteTypeController {

    @Autowired
    private NoteTypeService noteTypeService;

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public ModelAndView listNoteType(Pageable pageable){
        Page<NoteType> noteTypes = noteTypeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/noteType/list");
        modelAndView.addObject("noteTypes", noteTypes);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/noteType/create");
        modelAndView.addObject("noteType", new NoteType());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveNoteType(@ModelAttribute NoteType noteType){
        noteTypeService.save(noteType);
        if (noteType != null) {
            ModelAndView modelAndView = new ModelAndView("/noteType/create");
            modelAndView.addObject("noteType", noteType);
            modelAndView.addObject("message", "created");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditNoteTForm(@PathVariable Long id){
        NoteType noteType = noteTypeService.findById(id);
        if (noteType != null) {
            ModelAndView modelAndView = new ModelAndView("/noteType/edit");
            modelAndView.addObject("noteType", noteType);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public ModelAndView updateNote(@ModelAttribute ("note") NoteType noteType){
        noteTypeService.save(noteType);
        ModelAndView modelAndView = new ModelAndView("/noteType/edit");
        modelAndView.addObject("noteType", noteType);
        modelAndView.addObject("message", "updated successfully ");
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public ModelAndView deleteNoteType(@PathVariable Long id) {
        NoteType noteType = noteTypeService.findById(id);
        if (noteType != null) {
            ModelAndView modelAndView = new ModelAndView("/noteType/delete");
            modelAndView.addObject("noteType", noteType);
            modelAndView.addObject("message", "delete successfully");
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/remove")
    public String deleteNoteType(@ModelAttribute NoteType noteType){
        noteTypeService.remove(noteType.getId());
        return "redirect:list";

    }

    @GetMapping("/view/{id}")
    public ModelAndView viewNoteType(@PathVariable Long id){
        NoteType noteType = noteTypeService.findById(id);
        if(noteType == null){
            return new ModelAndView("/error-404");
        }

        Iterable<Note> notes = noteService.findAllByNoteType(noteType);

        ModelAndView modelAndView = new ModelAndView("/noteType/view");
        modelAndView.addObject("noteType", noteType);
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

}