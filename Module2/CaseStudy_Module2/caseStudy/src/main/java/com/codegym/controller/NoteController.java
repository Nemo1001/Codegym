package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.model.NoteType;
import com.codegym.service.NoteService;
import com.codegym.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteTypeService noteTypeService;

    @ModelAttribute("NoteTypes")
    public Page<NoteType> noteTypes(Pageable pageable) {
        return noteTypeService.findAll(pageable);
    }

           @GetMapping("/list")
            public ModelAndView showNoteList(@ModelAttribute("s") Optional<String> s, @PageableDefault(size = 5, sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
                Page<Note> noteList;
                if (s.isPresent()){
                    noteList = noteService.findAllByTitleContaining(s.get(), pageable);
                }else {
                    noteList = noteService.findAll(pageable);
                }
                ModelAndView modelAndView = new ModelAndView("/note/list");
                modelAndView.addObject("noteList", noteList);
                return modelAndView;
            }

            @GetMapping("/create")
            public ModelAndView createForm() {
                ModelAndView modelAndView = new ModelAndView("/note/create");
                modelAndView.addObject("note", new Note());
                return modelAndView;
            }

            @PostMapping("/save")
            public ModelAndView saveNoteType(@ModelAttribute Note note) {
                noteService.save(note);
                if (note != null) {
                    ModelAndView modelAndView = new ModelAndView("/note/create");
                    modelAndView.addObject("note", note);
                    modelAndView.addObject("message", "created");
                    return modelAndView;
                } else {
                    ModelAndView modelAndView = new ModelAndView("/error-404");
                    return modelAndView;
                }
            }

            @GetMapping("/edit/{id}")
            public ModelAndView showEditNoteForm(@PathVariable Long id){
                Note note = noteService.findById(id);
                if (note != null) {
                    ModelAndView modelAndView = new ModelAndView("/note/edit");
                    modelAndView.addObject("note", note);
                    return modelAndView;
                }else {
                    ModelAndView modelAndView = new ModelAndView("/error-404");
                    return modelAndView;
                }
            }

            @PostMapping("/update")
            public ModelAndView updateNote(@ModelAttribute ("note") Note note){
                noteService.save(note);
                ModelAndView modelAndView = new ModelAndView("/note/edit");
                modelAndView.addObject("note", note);
                modelAndView.addObject("message", "updated successfully ");
                return modelAndView;
            }

            @GetMapping("/delete/{id}")
            public ModelAndView deleteNote(@PathVariable Long id){
                Note note = noteService.findById(id);
                if (note != null) {
                    ModelAndView modelAndView = new ModelAndView("/note/delete");
                    modelAndView.addObject("note", note);
                    return modelAndView;
                }else {
                    ModelAndView modelAndView = new ModelAndView("/error-404");
                    return modelAndView;
                }
            }

            @PostMapping("/remove")
            public String deleteNote(@ModelAttribute Note note){
                noteService.remove(note.getId());
                return "redirect:list";

            }
        }