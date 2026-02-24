package IFC33B.FCT.dto;

import java.time.LocalDate;

import IFC33B.FCT.Model.Alumne;
import IFC33B.FCT.Model.Empresa;
import IFC33B.FCT.Model.TutorCentre;
import IFC33B.FCT.Model.TutorEmpresa;
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
    private TutorCentre tutorCentre;
    @NotBlank
    private String estat;
    @NotBlank
    private String observacions;
}
