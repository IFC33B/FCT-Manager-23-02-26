package IFC33B.FCT.dto;

import IFC33B.FCT.model.TutorCentre;
import lombok.Data;

@Data
public class TutorCentreResponse {

    // Atributs
    private String nom;
    private String cognom;
    private String email;
    private String telefon;
    private String carrec;

    // Constructor
    public TutorCentreResponse(TutorCentre tutor) {
        this.setNom(tutor.getNombre());
        this.setCognom(tutor.getCognom());
        this.setEmail(tutor.getEmail());
        this.setTelefon(tutor.getTelefon());
        this.setCarrec(tutor.getCarreg());
    }
}
