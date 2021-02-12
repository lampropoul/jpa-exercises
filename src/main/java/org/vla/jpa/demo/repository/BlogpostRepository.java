package org.vla.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.vla.jpa.demo.model.Blogpost;

@Repository
public interface BlogpostRepository extends JpaRepository<Blogpost, Long> {

}
