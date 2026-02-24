package IFC33B.FCT.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CicleRequest {
    @NotBlank
    private String nom;
    @NotBlank
    private String grau;
    @NotBlank
    private String famliaProfessional;
    @NotBlank
    private String codi;
}
