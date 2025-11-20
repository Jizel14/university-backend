package com.example.springtest.repository;

import com.example.springtest.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepo extends JpaRepository<University,Long> {
}
