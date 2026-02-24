package IFC33B.FCT.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import IFC33B.FCT.model.*;
import java.util.List;

@RestController
@RequestMapping("api/tutors")
public class TutorsControllers {


    @GetMapping
    public ResponseEntity<List<Tutor>> getAllTutors() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getAllTutors(@RequestParam Long id) {
    }

    @PostMapping
    public ResponseEntity<TutorResponse> createTutor(Tutor tutor) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponse> editarTutor(@RequestParam Long id, TutorRequest tutorRequest) {

    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<Tutor> cancelarCita(@RequestParam Long id) {

    }

}
