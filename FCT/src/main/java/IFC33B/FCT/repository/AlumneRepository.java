package IFC33B.FCT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import IFC33B.FCT.model.Alumne;

public interface AlumneRepository extends JpaRepository<Alumne, Long> {
    // Funcions per a trobar un alumne per el seu nom, per l'id, el objette alumne, i si existeix o no.
    Optional<Alumne> findById(Long id);
    boolean existsById(String name);
    Optional<Alumne> findByNom(String name);
    boolean existsByNom(String name);
}