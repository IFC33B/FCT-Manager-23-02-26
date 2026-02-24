package IFC33B.FCT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dashboard")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer totalAlumnes;

    @Column(nullable = false)
    private Integer totalEmpreses;

    @Column(nullable = false)
    private Integer totalTutors;

    @Column(nullable = false)
    private Integer totalCicles;

    @Column(nullable = false)
    private Integer convenisPendents;

    @Column(nullable = false)
    private Integer convenisActius;

    @Column(nullable = false)
    private Integer convenisFinalitzats;
}
