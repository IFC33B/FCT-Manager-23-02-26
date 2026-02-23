package IFC33B.FCT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/alumnes")
public class AlumneController {
    
    @GetMapping
    public int getAllAlumnes() {
        return 0;
    }
}
