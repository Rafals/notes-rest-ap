package com.example.recruitment_task.dto;

import java.time.LocalDateTime;

public record NoteDto(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        AuthorDto author
) {}
