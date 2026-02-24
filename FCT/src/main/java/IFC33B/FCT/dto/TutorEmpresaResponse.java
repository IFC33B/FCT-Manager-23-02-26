package IFC33B.FCT.dto;

import IFC33B.FCT.model.Empresa;
import IFC33B.FCT.model.TutorEmpresa;
import lombok.Data;

@Data
public class TutorEmpresaResponse {
    
    // Atributs
    private String nom;
    private String cognom;
    private String email;
    private String telefon;
    private String carrec;
    private String tipus;
    private Empresa empresa;

    // Constructor
    public TutorEmpresaResponse(TutorEmpresa tutor) {
        this.setNom(tutor.getNombre());
        this.setCognom(tutor.getCognom());
        this.setEmail(tutor.getEmail());
        this.setTelefon(tutor.getTelefon());
        this.setCarrec(tutor.getCarreg());
        this.setEmpresa(tutor.getEmpresa());
    }
}
