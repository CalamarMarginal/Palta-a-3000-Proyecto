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


import com.example.ProyectoISW.entity.SolicitudesPabellon;
import com.example.ProyectoISW.services.SpabellonService;

@CrossOrigin
@RestController
@RequestMapping("/solicitudpabellon")
public class SolicitudesPabellonController {

	@Autowired
	private SpabellonService SPservice;
	
	 @GetMapping("/{id}")
	 public ResponseEntity getSolicitudP(@PathVariable Long id){
		 SolicitudesPabellon solicitud = SPservice.findSolicitudPById(id);
	     if (solicitud != null){
	    	 return new ResponseEntity<SolicitudesPabellon>(solicitud, HttpStatus.OK);
	     } else{
	         return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	     }
	 }

	@GetMapping("")
	public Iterable<SolicitudesPabellon> getSolicitudesP(){
        return SPservice.listAllSolicitudesP();
    }
	
	@PostMapping("")
	public ResponseEntity<SolicitudesPabellon> addSolicitudP(@RequestBody SolicitudesPabellon solicitud) {
		SPservice.saveSolicitudP(solicitud);
        return new ResponseEntity<SolicitudesPabellon>(solicitud,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity deleteSolicitudP(@PathVariable Long id){
        SolicitudesPabellon solicitud = SPservice.findSolicitudPById(id);
        if (solicitud != null){
            SPservice.deleteSolicitudP(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
