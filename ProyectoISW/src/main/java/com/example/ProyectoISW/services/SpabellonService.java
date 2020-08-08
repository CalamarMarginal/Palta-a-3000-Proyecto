package com.example.ProyectoISW.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoISW.entity.SolicitudesPabellon;
import com.example.ProyectoISW.repository.SolicitudPabellonRepo;

@Service("SpabellonService")
public class SpabellonService {
    @Autowired
    private SolicitudPabellonRepo SpabellonRepository;

    public SolicitudesPabellon saveSolicitudP (SolicitudesPabellon solicitud){
        return SpabellonRepository.save(solicitud);
    }

    public SolicitudesPabellon findSolicitudPById(Long id){
        return SpabellonRepository.findById(id).orElse(null);
    }

    public Iterable<SolicitudesPabellon> listAllSolicitudesP(){
        return SpabellonRepository.findAll();
    }
    
    public  void deleteSolicitudP(Long id){
    	SpabellonRepository.deleteById(id);
        return;
    }
    public SolicitudesPabellon updateSolicitudP(Long id, SolicitudesPabellon solicitud) {
    	SolicitudesPabellon solicitudInDB = SpabellonRepository.findById(id).get(); 
    	solicitudInDB.setDescripcion(solicitud.getDescripcion());
    	solicitudInDB.setIdPaciente(solicitud.getIdPaciente());
    	return SpabellonRepository.save(solicitudInDB);
    }
}
