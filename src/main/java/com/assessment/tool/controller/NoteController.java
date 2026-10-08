package com.assessment.tool.controller;

import com.assessment.tool.entity.Note;
import com.assessment.tool.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            note.setTitle(noteDetails.getTitle());
            note.setCategory(noteDetails.getCategory());
            note.setTopic(noteDetails.getTopic());
            note.setDescription(noteDetails.getDescription());
            note.setContent(noteDetails.getContent());
            note.setFileUrl(noteDetails.getFileUrl());
            note.setFileName(noteDetails.getFileName());
            note.setEducatorId(noteDetails.getEducatorId());
            note.setEducatorName(noteDetails.getEducatorName());
            note.setCreatedDate(noteDetails.getCreatedDate());
            return noteRepository.save(note);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }
}
