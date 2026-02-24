package IFC33B.FCT.controller;

import IFC33B.FCT.model.Empresa;
import IFC33B.FCT.repository.EmpresaRepository;
import IFC33B.FCT.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empreses")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getAll() {
        return empresaService.getAll();
    }

    @PostMapping
    public Empresa create(@Valid @RequestBody Empresa empresa) {
        return empresaService.create(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!empresaService.delete(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable Long id) {
        return empresaService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @Valid @RequestBody Empresa empresa) {
        return empresaService.update(id, empresa).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}

