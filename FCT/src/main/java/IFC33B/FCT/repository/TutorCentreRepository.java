package IFC33B.FCT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.Tutor;

public interface TutorCentreRepository extends JpaRepository<TutorCentre, Long> {
    Optional<TutorCentre> findById(Integer Id);
    boolean existsById(Integer Id);
}
