package com.example.Horas.PAT.Repository;

import com.example.Horas.PAT.Model.RegitroAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroAsistenciaRepository extends JpaRepository<RegitroAsistencia,Long> {
}
