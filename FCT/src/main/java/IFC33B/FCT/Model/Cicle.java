package IFC33B.FCT.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String grau;

    @Column(nullable = false)
    private String familiaProfessional;

    @Column(nullable = false)
    private String codi;

    @OneToMany(mappedBy = "cicle")
    private List<Alumne> alumnes;
}