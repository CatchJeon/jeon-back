package com.example.catchjeon_back.repository;

import com.example.catchjeon_back.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    boolean existsByMail(String mail);
}
