package IFC33B.FCT.dto;

import java.time.LocalDate;

import IFC33B.FCT.model.Alumne;
import IFC33B.FCT.model.Empresa;
import IFC33B.FCT.model.TutorCentre;
import IFC33B.FCT.model.TutorEmpresa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ConveniRequest {
    // Atributs
    @NotBlank
    private Alumne alumne;
    @NotBlank
    private Empresa empresa;
    @NotBlank
    private TutorEmpresa tutorEmpresa;
    @NotBlank
    private TutorCente tutorCentre;
    @NotBlank
    private String estat;
    @NotBlank
    private String observacions;
}
