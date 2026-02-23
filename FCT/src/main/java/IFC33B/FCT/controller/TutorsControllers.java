package IFC33B.FCT.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TutorsControllers {

    private TutorsService tutorsService;
    private TutorsRepository tutorsRepository;

    @GetMapping
    public ResponseEntity<List<Tutors>> getAllTutors() {

        List<Tutors> listaTutores = tutorsService.obtenerTutores();
        return ResponseEntity.ok(listaTutores);
    }

    @GetMapping
    public ResponseEntity<Tutors> getAllTutors(int id) {

        Tutors tutor = tutorsRepository.getById(id);
        return ResponseEntity.ok(tutor);
    }

    @PostMapping
    public ResponseEntity<Tutor>createTutor(Tutor tutor){

        Tutor newTutor = tutor;
        return ResponseEntity.ok(newTutor);

    }




}
