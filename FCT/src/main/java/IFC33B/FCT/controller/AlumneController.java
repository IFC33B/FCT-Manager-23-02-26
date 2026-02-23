package IFC33B.FCT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/alumnes")
public class AlumneController {
    
    @GetMapping
    public int getAllAlumnes() {
        return 0;
    }

    @GetMapping("/{id}")
    public int getAlumneById() {
        return 0;
    }

    @PostMapping
    public int createAlumne() {
        return 0;
    }

    @PutMapping
    public int updateAlumne() {
        return 0;
    }

    @DeleteMapping
    public int deleteAlumne() {
        return 0;
    }
}
