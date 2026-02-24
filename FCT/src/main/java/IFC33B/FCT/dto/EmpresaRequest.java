package IFC33B.FCT.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpresaRequest {
    // Atributs
    @NotBlank
    private String nom;
    @NotBlank
    private String cif;
    @NotBlank
    private String direccio;
    @NotBlank
    private String poblacio;
    @NotBlank
    private String codiPostal;
    @NotBlank
    private String provincia;
    @NotBlank
    private String telefon;
    @NotBlank
    private String email;
    @NotBlank
    private String web;
    @NotBlank
    private String sectorActivitat;
}
