package IFC33B.FCT.dto;

import java.time.LocalDate;

import IFC33B.FCT.Model.Alumne;
import IFC33B.FCT.Model.Convenis;
import IFC33B.FCT.Model.Empresa;
import IFC33B.FCT.Model.EstatConveni;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ConveniResponse {
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
    private LocalDate dataInici;
    @NotBlank
    private LocalDate dataFi;
    @NotBlank
    private int horesTotals;
    @NotBlank
    private EstatConveni estat;
    @NotBlank
    private String observacions;

    // Constructor
    public ConveniResponse(Conveni conveni) {
        this.setAlumne(conveni.getAlumne());
        this.setEmpresa(conveni.getEmpresa());
        this.setTutorEmpresa(conveni.getTutorEmpresa());
        this.setTutorCentre(conveni.getTutorCentre());
        this.setDataInici(conveni.getDataInici());
        this.setDataFi(conveni.getDataFi());
        this.setHoresTotals(conveni.getHores());
        this.setEstat(conveni.getEstat());
        this.setObservacions(conveni.getObservacions());
    }
}
