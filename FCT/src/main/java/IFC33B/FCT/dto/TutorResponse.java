package IFC33B.FCT.dto;

import java.util.Optional;

import IFC33B.FCT.model.Empresa;
import IFC33B.FCT.model.Tutor;
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
    public TutorResponse(Tutor tutor) {
        this.setNom(tutor.getNombre());
        this.setCognom(tutor.getCognom());
        this.setEmail(tutor.getEmail());
        this.setTelefon(tutor.getTelefon());
        this.setCarrec(tutor.getCarreg());
        this.setTipus(tutor.getTipus());
        this.setEmpresa(tutor.getEmpresa());
    }
}
