package com.example.Horas.PAT.Controller;

import com.example.Horas.PAT.Model.PAT;
import com.example.Horas.PAT.Repository.PATRepository;
import com.example.Horas.PAT.Service.PATService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pat")
public class PATController {
    private final PATService PatService;
    private final PATRepository PatRepository;

    public PATController(PATService PatService, PATRepository PatRepository) {
        this.PatService = PatService;
        this.PatRepository = PatRepository;
    }

    @PostMapping("/guardar")
    public ResponseEntity<PAT> guardarPAT(@RequestBody PAT Pat) {
        return ResponseEntity.ok(PatService.guardar(Pat));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PAT>> listarCategoria() {
        return ResponseEntity.ok(PatService.listar());
    }

    @GetMapping("/buscar/{Id}")
    public ResponseEntity<PAT> buscarPATPorId(@PathVariable String Id) {
        return PatService.BuscarPorId(Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{Id}")
    public ResponseEntity<Void> eliminarPAT(@PathVariable String Id) {
        PatService.eliminar(Id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{Id}")
    public ResponseEntity<PAT> actualizar(@PathVariable String Id, @RequestBody PAT Pat) {
        Pat.setId(Id);
        PAT PatActualizado = PatService.actualizar(Id, Pat);
        return ResponseEntity.ok(PatActualizado);
    }
}
