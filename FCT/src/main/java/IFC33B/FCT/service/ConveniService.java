package IFC33B.FCT.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IFC33B.FCT.repository.ConveniRepository;

@Service
public class ConveniService {

    // Injecció d'independencies
    @Autowired
    ConveniRepository conveniRepository;

    // TODO add CRUD methods
    public Optional<Conveni> findById(Integer id) {
        // TODO implement exception
        return conveniRepository.findById(id).orElseThrow(() -> new conveniNotFoundById(id));
    }

    public boolean existsById(Integer id) {
        return conveniRepository.existsById(id);
    }
}
