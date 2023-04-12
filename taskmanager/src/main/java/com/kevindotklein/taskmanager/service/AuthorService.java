package com.kevindotklein.taskmanager.service;

import com.kevindotklein.taskmanager.entity.Author;
import com.kevindotklein.taskmanager.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
