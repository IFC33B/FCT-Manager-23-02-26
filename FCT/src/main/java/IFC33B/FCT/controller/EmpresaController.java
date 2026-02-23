package IFC33B.FCT.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping
public class EmpresaController {
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> getAll(){
        return empresaRepository.findAll();

    }

    @PostMapping
    public Empresa create(@Valid @RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<void> delete(@PathVariable Long id){
        if (!empresaRepository.existsById(id)) return ResponseEntity.notFound().build();
        empresaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable Long id) {
        return empresaRepository.findById(id).map(ResponseEntity::ok);

    }

    @PutMapping
    public ResponseEntity<Empresa> update(@PathVariable Long Id, @Valid @RequestBody Empresa empresa){
        return empresaRepository.findById(id).map(existing -> {
            empresa.setId(id);
            return ResponseEntity.ok(empresaRepository.save(empresa));
        });
    }

}

