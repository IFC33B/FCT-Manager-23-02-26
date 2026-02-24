package IFC33B.FCT.dto;

import java.util.Optional;

import IFC33B.FCT.Model.Empresa;
import lombok.Data;

@Data
public class TutorResponse {

    // Atributs
    private String nom;
    private String cognom;
    private String email;
    private String telefon;
    private String carrec;
    private String tipus;
    private Optional<Empresa> empresa;

    // Constructor
    public TutorResponse(String nom, String cognom, String email, String telefon, String carrec, String tipus, Optional<Empresa> empresa) {
        this.setNom(nom);
        this.setCognom(cognom);
        this.setEmail(email);
        this.setTelefon(telefon);
        this.setCarrec(carrec);
        this.setTipus(tipus);
        this.setEmpresa(empresa);
    }
}
