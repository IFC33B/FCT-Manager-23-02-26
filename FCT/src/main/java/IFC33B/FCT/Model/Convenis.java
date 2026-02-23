package IFC33B.FCT.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "convenis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Convenis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "alumne_id", nullable = false)
    private Alumne alumne;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "tutor_empresa_id", nullable = false)
    private Tutor tutorEmpresa;

    @ManyToOne
    @JoinColumn(name = "tutor_centre_id", nullable = false)
    private Tutor tutorCentre;

    @Column(nullable = false)
    private LocalDate dataInici;

    @Column(nullable = false)
    private LocalDate dataFi;

    @Column(nullable = false)
    private int hores;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstatConveni estat;

    private String observacions;
}