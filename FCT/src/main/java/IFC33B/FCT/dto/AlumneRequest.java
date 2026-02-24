package IFC33B.FCT.dto;

import IFC33B.FCT.Model.Cicle;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlumneRequest {
    @NotBlank
    private String nom;
    @NotBlank
    private String cognom;
    @NotBlank
    private String dni;
    @NotBlank
    private String email;
    @NotBlank
    private String telefon;
    @NotBlank
    private String poblacio;
    @NotBlank
    private String cursEscolar;
    @NotBlank
    private Cicle cicle;
}
