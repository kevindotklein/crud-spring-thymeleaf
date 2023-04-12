package com.kevindotklein.taskmanager.repository;

import com.kevindotklein.taskmanager.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
