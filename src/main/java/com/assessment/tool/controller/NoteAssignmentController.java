package com.assessment.tool.controller;

import com.assessment.tool.entity.NoteAssignment;
import com.assessment.tool.repository.NoteAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note-assignments")
public class NoteAssignmentController {

    @Autowired
    private NoteAssignmentRepository noteAssignmentRepository;

    @GetMapping
    public List<NoteAssignment> getAllNoteAssignments() {
        return noteAssignmentRepository.findAll();
    }

    @PostMapping
    public NoteAssignment createNoteAssignment(@RequestBody NoteAssignment noteAssignment) {
        return noteAssignmentRepository.save(noteAssignment);
    }

    @DeleteMapping("/{id}")
    public void deleteNoteAssignment(@PathVariable Long id) {
        noteAssignmentRepository.deleteById(id);
    }
}
