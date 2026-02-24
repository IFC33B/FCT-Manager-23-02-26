package IFC33B.FCT.service;

import IFC33B.FCT.repository.AlumneRepository;
import IFC33B.FCT.repository.CicleRepository;
import IFC33B.FCT.repository.ConveniRepository;
import IFC33B.FCT.repository.EmpresaRepository;
import IFC33B.FCT.repository.TutorCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private AlumneRepository alumneRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private TutorCentreRepository tutorRepository;

    @Autowired
    private ConveniRepository conveniRepository;

    @Autowired
    private CicleRepository cicleRepository;

}