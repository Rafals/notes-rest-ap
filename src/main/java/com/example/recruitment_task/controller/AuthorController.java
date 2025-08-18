package com.example.recruitment_task.controller;

import com.example.recruitment_task.dto.AuthorDto;
import com.example.recruitment_task.dto.CreateAuthorDto;
import com.example.recruitment_task.exception.ResourceNotFoundException;
import com.example.recruitment_task.model.Author;
import com.example.recruitment_task.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public AuthorDto createAuthor(@Valid @RequestBody CreateAuthorDto dto) {
        Author author = new Author();
        author.setName(dto.name());
        Author saved = authorRepository.save(author);
        return new AuthorDto(saved.getId(), saved.getName());
    }

    @GetMapping
    public List<AuthorDto> getAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(a -> new AuthorDto(a.getId(), a.getName()))
                .toList();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        Author a = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        return new AuthorDto(a.getId(), a.getName());
    }
}
