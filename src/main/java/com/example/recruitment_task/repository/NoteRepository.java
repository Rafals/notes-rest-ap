package com.example.recruitment_task.repository;

import com.example.recruitment_task.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
