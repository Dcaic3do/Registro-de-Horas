package com.example.Horas.PAT.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegitroAsistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registroAsistencia;

    private LocalDate fecha;
    private LocalTime hora_ingreso;
    private LocalTime hora_salida;
    private  Long horas_trabajadas;

    @ManyToOne
    @JoinColumn(name = "id_pat")
    @JsonIgnore
    private PAT pat;
}
