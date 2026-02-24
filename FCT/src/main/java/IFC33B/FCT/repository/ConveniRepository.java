package IFC33B.FCT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.Conveni;

public interface ConveniRepository extends JpaRepository<Conveni, Long> {
    Optional<Conveni> findById(Long Id);
    boolean existsById(Integer Id);
}
