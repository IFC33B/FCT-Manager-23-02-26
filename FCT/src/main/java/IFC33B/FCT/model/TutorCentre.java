package IFC33B.FCT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tutor_centro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorCentre {

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

    @OneToOne(mappedBy = "tutorCentre")
    private Alumne alumne;

    @OneToMany(mappedBy = "tutorCentre")
    private List<Conveni> convenis;
}