package com.example.ProyectoISW.controllers;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProyectoISW.entity.ReservasSillon;
import com.example.ProyectoISW.services.RsillonService;

@RestController
@RequestMapping("/reservasillon")
public class ReservasSillonController {
	@Autowired
	private RsillonService RSservice;
	
	 @GetMapping("/{id}")
	 public ResponseEntity getReservaS(@PathVariable Long id){
		 ReservasSillon reserva = RSservice.findReservaSById(id);
	     if (reserva != null){
	    	 return new ResponseEntity<ReservasSillon>(reserva, HttpStatus.OK);
	     } else{
	         return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	     }
	 }

	@GetMapping("")
	public Iterable<ReservasSillon> getReservasS(){
        return RSservice.listAllReservasS();
    }
	
	@PostMapping("")
	public ResponseEntity<ReservasSillon> addReservaS(@RequestBody ReservasSillon reserva) {
		RSservice.saveReservaS(reserva);
        return new ResponseEntity<ReservasSillon>(reserva,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateReservaS(@PathVariable("id") long id,@RequestBody ReservasSillon reserva) {
        if (reserva != null){
            RSservice.updateReservaS(id, reserva);
            return new ResponseEntity<ReservasSillon>(reserva, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity deleteReservaP(@PathVariable Long id){
        ReservasSillon reserva = RSservice.findReservaSById(id);
        if (reserva != null){
            RSservice.deleteReservaS(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
