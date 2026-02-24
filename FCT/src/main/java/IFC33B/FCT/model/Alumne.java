package IFC33B.FCT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "alumnes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String cognom;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefon;

    @Column(nullable = false)
    private String poblacio;

    @Column(nullable = false)
    private String cursEscolar;

    @ManyToOne
    @JoinColumn(name = "cicle_id", nullable = false)
    private Cicle cicle;

    @ManyToOne
    @JoinColumn(name = "tutor_empresa_id")
    private TutorEmpresa tutorEmpresa;

    @OneToOne
    @JoinColumn(name = "tutor_centre_id")
    private TutorCentre tutorCentre;

    @OneToMany(mappedBy = "alumne")
    private List<Convenis> convenis;
}