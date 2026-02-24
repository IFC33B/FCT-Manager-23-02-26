package IFC33B.FCT.service;

import IFC33B.FCT.Model.Empresa;
import IFC33B.FCT.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa create(Empresa empresa) {
        if (empresaRepository.existsByCif(empresa.getCif())) {
            throw new RuntimeException("error");
        }
        return empresaRepository.save(empresa);
    }

    public boolean delete(Long id) {
        if (!empresaRepository.existsById(id)) return false;
        empresaRepository.deleteById(id);
        return true;
    }

    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getById(Long id) {
        return empresaRepository.findById(id);
    }

    public Optional<Empresa> update(Long id, Empresa empresa) {
        return empresaRepository.findById(id).map(existing -> {
            empresa.setId(id);
            return empresaRepository.save(empresa);
        });
    }
}
