package IFC33B.FCT.service; 

import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import IFC33B.FCT.model.Alumne; 
import IFC33B.FCT.repository.AlumneRepository; 
@Service 
public class AlumneService { 
    
    @Autowired 
    private AlumneRepository alumneRepository; 
    
    public Optional<Alumne> findById(Long id) { 
        if (!alumneRepository.existsById(id)) { 
            return Optional.empty(); 
        }
        return alumneRepository.findById(id); 
    }
    
    public boolean existsById(Long id) { 
        if (!alumneRepository.existsById(id)) { 
            return false; 
        }
        return true; 
    } 

    public Optional<Alumne> findByNom(String name) { 
        if (!alumneRepository.existsByNom(name)) { 
            return Optional.empty(); 
        }
        return alumneRepository.findByNom(name); 
    }

    public boolean existsByNom(String name) { 
        if (!alumneRepository.existsByNom(name)) { 
            return false; 
        }
        return true; 
    }
}