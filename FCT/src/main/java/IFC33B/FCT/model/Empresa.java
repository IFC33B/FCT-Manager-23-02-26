package IFC33B.FCT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empreses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String cif;

    @Column(nullable = false)
    private String poblacio;

    @Column(nullable = false)
    private int telefon;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String direccio;

    @Column(nullable = false)
    private String codiPostal;

    @Column(nullable = false)
    private String provincia;

    private String web;

    @Column(nullable = false)
    private String sectorActivitat;

    @OneToOne(mappedBy = "empresa")
    private TutorEmpresa tutorEmpresa;
}