package com.example.Horas.PAT.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PAT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id_pat;

    private String Nombre;

    private String Apellido;

    private String Id;

    @OneToMany(mappedBy = "pat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<RegitroAsistencia> regitroAsistencia;
}
