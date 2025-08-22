package com.example.Horas.PAT.Service;

import com.example.Horas.PAT.Model.PAT;
import com.example.Horas.PAT.Repository.PATRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PATService {
    private final PATRepository patRepository;

    public PATService(PATRepository patRepository) {
        this.patRepository = patRepository;
    }

    public PAT guardar(PAT pat) {
        return patRepository.save(pat);
    }

    public List<PAT> listar() {
        return patRepository.findAll();
    }

    public void eliminarPorCodigo(String codigo) {
        PAT pat = patRepository.findByCodigo(codigo)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un PAT con el código " + codigo));
        patRepository.delete(pat);
    }

    public PAT buscarPorCodigo(String codigo) {
        return patRepository.findByCodigo(codigo)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un PAT con el código " + codigo));
    }

    public PAT actualizarPorCodigo(String codigo, PAT patActualizado) {
        PAT existente = patRepository.findByCodigo(codigo)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un PAT con el código " + codigo));

        existente.setNombre(patActualizado.getNombre());
        existente.setApellido(patActualizado.getApellido());
        existente.setCodigo(patActualizado.getCodigo());

        return patRepository.save(existente);
    }
}

