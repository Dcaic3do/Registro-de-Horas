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
    private final PATService patService;

    public PATController(PATService patService) {
        this.patService = patService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<PAT> guardar(@RequestBody PAT pat) {
        return ResponseEntity.ok(patService.guardar(pat));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PAT>> listar() {
        return ResponseEntity.ok(patService.listar());
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<PAT> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(patService.buscarPorCodigo(codigo));
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<String> eliminarPorCodigo(@PathVariable String codigo) {
        patService.eliminarPorCodigo(codigo);
        return ResponseEntity.ok("PAT eliminado con éxito");
    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<PAT> actualizarPorCodigo(@PathVariable String codigo, @RequestBody PAT pat) {
        return ResponseEntity.ok(patService.actualizarPorCodigo(codigo, pat));
    }
}

