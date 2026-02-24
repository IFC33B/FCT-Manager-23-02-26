package IFC33B.FCT.dto;

import java.util.Optional;

import IFC33B.FCT.model.Empresa;
import lombok.Data;

@Data
public class TutorRequest {
    // Atributs
    private String nom;
    private String cognom;
    private String email;
    private String telefon;
    private String carrec;
    private String tipus;
    private Optional<Empresa> empresa;
}
