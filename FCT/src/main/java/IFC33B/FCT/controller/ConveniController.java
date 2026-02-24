package IFC33B.FCT.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IFC33B.FCT.model.Conveni;
import IFC33B.FCT.repository.ConveniRepository;

@RestController
@RequestMapping
public class ConveniController {
    
    // GET api/convenis
    @GetMapping
    public int getAllConvenis() {
        return 0;
    }

    // GET /api/convenis/{id}
    @GetMapping
    public int getAllConvenisById() {
        return 0;
    }

    // POST api/convenis
    @PostMapping
    public int createConveni() {
        return 0;
    }

    // PUT  /api/convenis{id}
    @PutMapping
    public int updateConveniById() {
        return 0;
    }

    // DELETE /api/convenis{id}
    @DeleteMapping
    public int deleteConveniById() {
        return 0;
    }

}
