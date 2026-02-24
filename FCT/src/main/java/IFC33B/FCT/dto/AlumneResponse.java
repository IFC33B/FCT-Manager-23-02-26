package IFC33B.FCT.dto;

import IFC33B.FCT.model.Alumne;
import IFC33B.FCT.model.Cicle;
import lombok.Data;

@Data
public class AlumneResponse {
    private Long id;
    private String nom;
    private String cognom;
    private String dni;
    private String email;
    private String telefon;
    private String poblacio;
    private String cursEscolar;
    private Cicle cicle;

    public AlumneResponse(Alumne alumne) {
        this.setId(alumne.getId());
        this.setNom(alumne.getNom());
        this.setCognom(alumne.getCognom());
        this.setDni(alumne.getDni());
        this.setEmail(alumne.getEmail());
        this.setTelefon(alumne.getTelefon());
        this.setPoblacio(alumne.getPoblacio());
        this.setCursEscolar(alumne.getCursEscolar());
        this.setCicle(alumne.getCicle());
    }
}
