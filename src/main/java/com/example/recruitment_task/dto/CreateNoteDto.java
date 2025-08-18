package com.example.recruitment_task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateNoteDto(
        @NotBlank(message = "Title is required")
        String title,
        String content,
        @NotNull(message = "Author ID is required")
        Long authorId
) {}
