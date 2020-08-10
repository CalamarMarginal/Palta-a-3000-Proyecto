package com.example.ProyectoISW.controllers;
//import  java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.validation.Valid;
import com.example.ProyectoISW.entity.ReservasPabellon;
import com.example.ProyectoISW.services.RpabellonService;

@CrossOrigin
@RestController
@RequestMapping("/reservapabellon")
public class ReservasPabellonController {
	@Autowired
	private RpabellonService RPservice;
	
	 @GetMapping("/{id}")
	 public ResponseEntity getReservaP(@PathVariable Long id){
		 ReservasPabellon reserva = RPservice.findReservaPById(id);
	     if (reserva != null){
	    	 return new ResponseEntity<ReservasPabellon>(reserva, HttpStatus.OK);
	     } else{
	         return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	     }
	 }

	@GetMapping("")
	public Iterable<ReservasPabellon> getReservasP(){
        return RPservice.listAllReservasP();
    }
	
	@PostMapping("")
	public ResponseEntity<ReservasPabellon> addReservaP(@RequestBody ReservasPabellon reserva) {
		RPservice.saveReservaP(reserva);
        return new ResponseEntity<ReservasPabellon>(reserva,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateReservaP(@PathVariable Long id,@RequestBody ReservasPabellon reserva) {
        if (reserva != null){
            RPservice.updateReservaP(id, reserva);
            return new ResponseEntity<ReservasPabellon>(reserva, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity deleteReservaP(@PathVariable Long id){
        ReservasPabellon reserva = RPservice.findReservaPById(id);
        if (reserva != null){
            RPservice.deleteReservaP(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
