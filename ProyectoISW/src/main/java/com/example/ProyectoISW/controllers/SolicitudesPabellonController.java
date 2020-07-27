package com.example.ProyectoISW.controllers;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProyectoISW.entity.SolicitudesPabellon;
import com.example.ProyectoISW.repository.SolicitudPabellonRepo;

@Controller
@RequestMapping("/solicitudpabellon")
public class SolicitudesPabellonController {

	@Autowired
	private SolicitudPabellonRepo SPrepo;
	
	@GetMapping("showForm")
	public String ShowSolicitudPForm(){
		return "add-solicitudpabellon";
	}
	
	@GetMapping("list")
	public String reservas(Model model) {
		model.addAttribute("solicitudesP", this.SPrepo.findAll());
		return "index";
	}
	
	@PostMapping("add")
	public String addReserva(/*@Valid*/ SolicitudesPabellon solicitud, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "add-solicitudpabellon";
		}
		this.SPrepo.save(solicitud);
		return "redirect:list";
	}
	
	/*@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		SolicitudesPabellon solicitud = (SolicitudesPabellon) this.SPrepo.findById(id);
		model.addAttribute("solicitudP", solicitud);
		return "update-solicitudP";
	}
	
	@PostMapping("update/{id}")
	public String updateCar(@PathVariable("id") long id,SolicitudesPabellon solicitud, BindingResult result, Model model) {
		if(result.hasErrors()) {
			solicitud.setId(id);
			return "update-solicitudP";
		}
		SPrepo.save(solicitud);
		model.addAttribute("solicitudP", this.SPrepo.findAll());
		return "index";
	}*/
	
	@DeleteMapping("delete/{id}")
	public String deleteCar(@PathVariable("id") long id, Model model) {
		SolicitudesPabellon solicitud = (SolicitudesPabellon) this.SPrepo.findById(id);
		this.SPrepo.delete(solicitud);
		model.addAttribute("solicitudesP", this.SPrepo.findAll());
		return "index";
	}

}
