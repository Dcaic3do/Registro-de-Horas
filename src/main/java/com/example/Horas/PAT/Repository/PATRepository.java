package com.example.Horas.PAT.Repository;

import com.example.Horas.PAT.Model.PAT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PATRepository extends JpaRepository<PAT,String> {
    Optional<PAT> findById(String Id);
}
