package com.example.springtest.repository;

import com.example.springtest.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepo extends JpaRepository<Bloc, Long> {

}
