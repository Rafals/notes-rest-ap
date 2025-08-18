package com.example.recruitment_task.repository;

import com.example.recruitment_task.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
