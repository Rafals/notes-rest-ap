package com.example.recruitment_task.controller;

import com.example.recruitment_task.dto.AuthorDto;
import com.example.recruitment_task.dto.CreateNoteDto;
import com.example.recruitment_task.dto.NoteDto;
import com.example.recruitment_task.model.Author;
import com.example.recruitment_task.model.Note;
import com.example.recruitment_task.repository.AuthorRepository;
import com.example.recruitment_task.repository.NoteRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;
    private final AuthorRepository authorRepository;

    public NoteController(NoteRepository noteRepository, AuthorRepository authorRepository) {
        this.noteRepository = noteRepository;
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public NoteDto createNote(@Valid @RequestBody CreateNoteDto dto) {
        Author author = authorRepository.findById(dto.authorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Note note = new Note();
        note.setTitle(dto.title());
        note.setContent(dto.content());
        note.setAuthor(author);
        note.setCreatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);
        return new NoteDto(saved.getId(), saved.getTitle(), saved.getContent(),
                saved.getCreatedAt(),
                new AuthorDto(author.getId(), author.getName()));
    }

    @GetMapping
    public List<NoteDto> getNotes() {
        return noteRepository.findAll()
                .stream()
                .map(n -> new NoteDto(
                        n.getId(),
                        n.getTitle(),
                        n.getContent(),
                        n.getCreatedAt(),
                        new AuthorDto(n.getAuthor().getId(), n.getAuthor().getName())))
                .toList();
    }

    @GetMapping("/{id}")
    public NoteDto getNoteById(@PathVariable Long id) {
        Note n = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        return new NoteDto(
                n.getId(),
                n.getTitle(),
                n.getContent(),
                n.getCreatedAt(),
                new AuthorDto(n.getAuthor().getId(), n.getAuthor().getName()));
    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable Long id) {
        if (!noteRepository.existsById(id)) {
            throw new RuntimeException("Note not found");
        }
        noteRepository.deleteById(id);
    }
}
