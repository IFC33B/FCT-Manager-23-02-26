package IFC33B.FCT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.Convenio;

public interface ConveniRepository extends JpaRepository<Conveni, Long> {
    Optional<Conveni> findById(Integer Id);
    boolean existsById(Integer Id);
}
