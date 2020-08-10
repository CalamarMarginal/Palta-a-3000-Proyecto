package com.example.ProyectoISW.controllers;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.ProyectoISW.entity.SolicitudesSillon;
import com.example.ProyectoISW.services.SsillonService;

@CrossOrigin
@RestController
@RequestMapping("/solicitudsillon")
public class SolicitudesSillonController {

	@Autowired
	private SsillonService SSservice;
	
	 @GetMapping("/{id}")
	 public ResponseEntity getSolicitudS(@PathVariable Long id){
		 SolicitudesSillon solicitud = SSservice.findSolicitudSById(id);
	     if (solicitud != null){
	    	 return new ResponseEntity<SolicitudesSillon>(solicitud, HttpStatus.OK);
	     } else{
	         return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	     }
	 }

	@GetMapping("")
	public Iterable<SolicitudesSillon> getSolicitudesS(){
        return SSservice.listAllSolicitudesS();
    }
	
	@PostMapping("")
	public ResponseEntity<SolicitudesSillon> addSolicitudS(@RequestBody SolicitudesSillon solicitud) {
		SSservice.saveSolicitudS(solicitud);
        return new ResponseEntity<SolicitudesSillon>(solicitud,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity deleteSolicitudS(@PathVariable Long id){
        SolicitudesSillon solicitud = SSservice.findSolicitudSById(id);
        if (solicitud != null){
            SSservice.deleteSolicitudS(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
