package IFC33B.FCT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.Tutor;

public interface TutorEmpresaRepository extends JpaRepository<TutorEmpresa, Long> {
    Optional<TutorEmpresa> findById(Integer Id);
    boolean existsById(Integer Id);
}
