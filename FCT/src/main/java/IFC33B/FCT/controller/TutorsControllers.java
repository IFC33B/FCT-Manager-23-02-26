package IFC33B.FCT.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/tutors")
public class TutorsControllers {


    @GetMapping
    public ResponseEntity<List<Tutors>> getAllTutors() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutors> getAllTutors(@RequestParam Long id) {
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
