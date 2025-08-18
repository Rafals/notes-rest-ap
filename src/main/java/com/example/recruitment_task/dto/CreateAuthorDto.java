package com.example.recruitment_task.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateAuthorDto(
        @NotBlank(message = "Author name is required")
        String name
) {}
