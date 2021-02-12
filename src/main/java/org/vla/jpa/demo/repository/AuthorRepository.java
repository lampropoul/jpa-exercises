package org.vla.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.vla.jpa.demo.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
