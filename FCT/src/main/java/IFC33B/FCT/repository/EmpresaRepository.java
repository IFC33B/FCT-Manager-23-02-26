package IFC33B.FCT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
}
