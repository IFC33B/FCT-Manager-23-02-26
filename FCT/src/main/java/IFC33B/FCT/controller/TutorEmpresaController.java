package IFC33B.FCT.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import IFC33B.FCT.model.*;
import java.util.List;

@RestController
@RequestMapping("api/tutorempresa")
public class TutorEmpresaController {


    @GetMapping
    public int getAllTutors() {
        return 0;

    }

    @GetMapping("/{id}")
    public int getAllTutors(@RequestParam Long id) {
        return 0;
    }

    @PostMapping
    public int createTutor(TutorEmpresa tutorEmpresa) {
        return 0;

    }

    @PutMapping("/{id}")
    public int editarTutor(@RequestParam Long id, TutorEmpresa tutorEmpresa) {
        return 0;
    }

    @PutMapping("/{id}/delete")
    public int cancelarCita(@RequestParam Long id) {
        return 0;
    }

}
