package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {}
