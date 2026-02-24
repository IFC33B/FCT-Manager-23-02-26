package IFC33B.FCT.dto;

import lombok.Data;

@Data
public class DashboardResponse {
    private Integer totalAlumnes;
    private Integer totalEmpreses;
    private Integer totalTutors;
    private Integer totalCicles;
    private Integer convenisPendents;
    private Integer convenisActius;
    private Integer convenisFinalitzats;

    public DashboardResponse(Dashboard dashboard) {
        this.setTotalAlumnes(dashboard.getTotalAlumnes());
        this.setTotalEmpreses(dashboard.getTotalEmpreses());
        this.setTotalTutors(dashboard.getTotalTutors());
        this.setTotalCicles(dashboard.getTotalCicles());
        this.setConvenisPendents(dashboard.getConvenisPendents());
        this.setConvenisActius(dashboard.getConvenisActius());
        this.setConvenisFinalitzats(dashboard.getConvenisFinalitzats());
    }
}
