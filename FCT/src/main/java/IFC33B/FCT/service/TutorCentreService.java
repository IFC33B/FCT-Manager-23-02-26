package IFC33B.FCT.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IFC33B.FCT.model.TutorCentro;
import IFC33B.FCT.repository.TutorCentreRepository;

@Service
public class TutorCentreService {
    
    @Autowired
    private TutorCentreRepository tutorCentreRepository;

    public Optional<TutorCentro> findById(Long id) {
        if (!tutorCentreRepository.existsById(id)) {
            return Optional.empty();
        }
        return tutorCentreRepository.findById(id);
    }

    public boolean existsById(Long id) {
        if (!tutorCentreRepository.existsById(id)) {
            return false;
        }
        return tutorCentreRepository.existsById(id);
    }
}
