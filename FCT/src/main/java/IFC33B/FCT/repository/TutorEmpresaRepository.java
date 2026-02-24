package IFC33B.FCT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.TutorEmpresa;

public interface TutorEmpresaRepository extends JpaRepository<TutorEmpresa, Long> {
    Optional<TutorEmpresa> findById(Long Id);
    boolean existsById(Long Id);
}
