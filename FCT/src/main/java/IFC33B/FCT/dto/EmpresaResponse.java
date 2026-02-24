package IFC33B.FCT.dto;

import IFC33B.FCT.model.Empresa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpresaResponse {
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

    public EmpresaResponse(Empresa empresa) {
        this.setNom(empresa.getNom());
        this.setCif(empresa.getCif());
        this.setDireccio(empresa.getDireccio());
        this.setPoblacio(empresa.getPoblacio());
        this.setCodiPostal(empresa.getCodiPostal());
        this.setProvincia(empresa.getProvincia());
        this.setTelefon(empresa.getTelefon());
        this.setEmail(empresa.getEmail());
        this.setWeb(empresa.getWeb());
        this.setSectorActivitat(empresa.getSectorActivitat());
    }
}
