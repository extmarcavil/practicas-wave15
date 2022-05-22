package com.example.demo.repository;

import com.example.demo.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoJoya extends JpaRepository<Joya,Long> {

}
