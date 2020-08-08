package com.example.ProyectoISW.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoISW.entity.SolicitudesSillon;
import com.example.ProyectoISW.repository.SolicitudSillonRepo;

@Service("SsillonService")
public class SsillonService {
    @Autowired
    private SolicitudSillonRepo SsillonRepository;

    public SolicitudesSillon saveSolicitudS (SolicitudesSillon solicitud){
        return SsillonRepository.save(solicitud);
    }

    public SolicitudesSillon findSolicitudSById(Long id){
        return SsillonRepository.findById(id).orElse(null);
    }

    public Iterable<SolicitudesSillon> listAllSolicitudesS(){
        return SsillonRepository.findAll();
    }
    
    public  void deleteSolicitudS(Long id){
    	SsillonRepository.deleteById(id);
        return;
    }
    public SolicitudesSillon updateSolicitudP(Long id, SolicitudesSillon solicitud) {
    	SolicitudesSillon solicitudInDB = SsillonRepository.findById(id).get(); 
    	solicitudInDB.setDescripcion(solicitud.getDescripcion());
    	solicitudInDB.setIdPaciente(solicitud.getIdPaciente());
    	return SsillonRepository.save(solicitudInDB);
    }
}
