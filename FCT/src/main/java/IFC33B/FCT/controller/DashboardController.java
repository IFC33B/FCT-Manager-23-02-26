package IFC33B.FCT.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping("/stats")
    public int getAllStats() {
        return
    }
}
