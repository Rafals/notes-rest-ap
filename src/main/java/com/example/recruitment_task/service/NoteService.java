package com.example.recruitment_task.service;

import com.example.recruitment_task.exception.NotFoundException;
import com.example.recruitment_task.model.Note;
import com.example.recruitment_task.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Note not found with id: " + id));
    }

    public void deleteNoteById(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new NotFoundException("Note not found with id: " + id);
        }
        noteRepository.deleteById(id);
    }
}
