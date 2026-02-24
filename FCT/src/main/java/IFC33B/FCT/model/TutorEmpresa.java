package IFC33B.FCT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tutor_empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String cognom;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefon;

    @Column(nullable = false)
    private String carreg;

    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany(mappedBy = "tutorEmpresa")
    private List<Alumne> alumnes;

    @OneToMany(mappedBy = "tutorEmpresa")
    private List<Convenis> convenis;
}