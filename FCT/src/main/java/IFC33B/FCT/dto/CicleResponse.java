package IFC33B.FCT.dto;

import IFC33B.FCT.model.Cicle;
import lombok.Data;

@Data
public class CicleResponse {
    private Long id;
    private String nom;
    private String grau;
    private String famliaProfessional;
    private String codi;

    public CicleResponse(Cicle cicle) {
        this.setId(cicle.getId());
        this.setNom(cicle.getNom());
        this.setGrau(cicle.getGrau());
        this.setFamliaProfessional(cicle.getFamiliaProfessional());
        this.setCodi(cicle.getCodi());
    }
}
