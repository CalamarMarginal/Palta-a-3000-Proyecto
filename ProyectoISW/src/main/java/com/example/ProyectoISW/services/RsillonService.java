package com.example.ProyectoISW.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoISW.entity.ReservasSillon;
import com.example.ProyectoISW.repository.ReservaSillonRepo;

@Service("RsillonService")
public class RsillonService {
    @Autowired
    private ReservaSillonRepo RsillonRepository;

    public ReservasSillon saveReservaS (ReservasSillon reserva){
        return RsillonRepository.save(reserva);
    }

    public ReservasSillon findReservaSById(Long id){
        return RsillonRepository.findById(id).orElse(null);
    }

    public Iterable<ReservasSillon> listAllReservasS(){
        return RsillonRepository.findAll();
    }
    
    public  void deleteReservaS(Long id){
    	RsillonRepository.deleteById(id);
        return;
    }
    public ReservasSillon updateReservaS(Long id, ReservasSillon reserva) {
    	ReservasSillon reservaInDB = RsillonRepository.findById(id).get(); 
    	reservaInDB.setIdSillon(reserva.getIdSillon());
		reservaInDB.setIdSolicitud(reserva.getIdSolicitud());
		reservaInDB.setReservado(reserva.getReservado());
		reservaInDB.setHorario(reserva.getHorario());
    	return RsillonRepository.save(reservaInDB);
    }
}
