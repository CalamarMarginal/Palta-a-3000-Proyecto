package com.example.ProyectoISW.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoISW.entity.ReservasPabellon;
import com.example.ProyectoISW.repository.ReservaPabellonRepo;


@Service("RpabellonService")
public class RpabellonService {
    @Autowired
    private ReservaPabellonRepo RpabellonRepository;

    public ReservasPabellon saveReservaP(ReservasPabellon reserva){
        return RpabellonRepository.save(reserva);
    }

    public ReservasPabellon findReservaPById(Long id){
        return RpabellonRepository.findById(id).orElse(null);
    }

    public Iterable<ReservasPabellon> listAllReservasP(){
        return RpabellonRepository.findAll();
    }
    
    public  void deleteReservaP(Long id){
    	RpabellonRepository.deleteById(id);
        return;
    }
    public ReservasPabellon updateReservaP(Long id, ReservasPabellon reserva) {
    	ReservasPabellon reservaInDB = RpabellonRepository.findById(id).get(); 
    	reservaInDB.setIdPabellon(reserva.getIdPabellon());
		reservaInDB.setIdSolicitud(reserva.getIdSolicitud());
		reservaInDB.setReservado(reserva.getReservado());
		reservaInDB.setHorario(reserva.getHorario());
    	return RpabellonRepository.save(reservaInDB);
    }
}
