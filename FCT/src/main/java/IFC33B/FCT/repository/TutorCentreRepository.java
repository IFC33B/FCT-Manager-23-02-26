package IFC33B.FCT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.TutorCentre;

public interface TutorCentreRepository extends JpaRepository<TutorCentre, Long> {
    Optional<TutorCentre> findById(Long Id);
    boolean existsById(Long Id);
}
