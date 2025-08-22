package com.example.Horas.PAT.Service;

import com.example.Horas.PAT.Model.PAT;
import com.example.Horas.PAT.Repository.PATRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PATService {
    private final PATRepository PatRepository;

    public PATService(PATRepository PatRepository) {this.PatRepository = PatRepository;}

    public PAT guardar(PAT Pat) {
        try {
            return PatRepository.save(Pat);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el nuevo PAT" + e.getMessage(), e);
        }
    }

    public List<PAT> listar(){
        try {
            return PatRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("No se pudieron mostrar todos los PATs. " + e.getMessage(), e);
        }
    }

    public void eliminar(String Id){
        try {
            PAT pat = PatRepository.findById(Id)
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró un PAT con Id: " + Id));

            PatRepository.delete(pat);

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el PAT. " + e.getMessage(), e);
        }

    }

    public Optional<PAT> BuscarPorId(String Id) {
        try {
            if (PatRepository.findById(Id).isEmpty()) {
                throw new IllegalArgumentException("No se encontró un PAT con el Id " + Id);
            }
            return PatRepository.findById(Id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar PAT por Id" + e.getMessage(), e);
        }
    }

    public PAT actualizar(String Id, PAT Pat) {
        if (PatRepository.findById(Id).isEmpty()) {
            throw new IllegalArgumentException("No se encontró un PAT con el id " + Id);
        }
        return PatRepository.save(Pat);
    }
}
