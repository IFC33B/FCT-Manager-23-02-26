package IFC33B.FCT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findById(Long id);
    boolean existsById(Long id);
    boolean existsByCif(String cif);
}
