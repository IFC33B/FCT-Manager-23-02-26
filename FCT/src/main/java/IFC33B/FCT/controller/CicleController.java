package IFC33B.FCT.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/cicles")
public class CicleController {

    @GetMapping
    public ResponseEntity<List<Cicle>> getAllCicles()
    {}

    @GetMapping("/{id}")
    public ResponseEntity<Cicle>getCicles(@PathVariable int id)
    {}

    @PostMapping
    public int createCicle()
    {}

    @PutMapping("/edit/{id}")
    public int editCicle(@PathVariable int id)
    {}

    @PutMapping("cancel/{id}")
    public int cancelCicle (@PathVariable int id)
    {}
}
