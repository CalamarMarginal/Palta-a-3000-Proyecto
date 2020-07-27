package com.example.ProyectoISW.controllers;
//import  java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.validation.Valid;
import com.example.ProyectoISW.entity.ReservasPabellon;
import com.example.ProyectoISW.repository.ReservaPabellonRepo;

@RestController
@RequestMapping("/reservapabellon")
public class ReservasPabellonController {
	@Autowired
	private ReservaPabellonRepo RPrepo;
	
	@GetMapping("showForm")
	public String ShowReservaPForm(){
		return "add-reservapabellon";
	}
	
	@GetMapping("list")
	public String reservas(Model model) {
		model.addAttribute("reservasP", this.RPrepo.findAll());
		return "index";
	}
	
	@PostMapping("add")
	public String addReserva(/*@Valid*/ ReservasPabellon reserva, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "add-reservapabellon";
		}
		this.RPrepo.save(reserva);
		return "redirect:list";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		ReservasPabellon reserva = (ReservasPabellon) this.RPrepo.findById(id);
		model.addAttribute("reservaP", reserva);
		return "update-reservaP";
	}
	
	@PutMapping("update/{id}")
	public String updateCar(@PathVariable("id") long id, ReservasPabellon reserva, BindingResult result, Model model) {
		if(result.hasErrors()) {
			reserva.setId(id);
			return "update-reservaP";
		}
		RPrepo.save(reserva);
		model.addAttribute("reservasP", this.RPrepo.findAll());
		return "index";
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteCar(@PathVariable("id") long id, Model model) {
		ReservasPabellon reserva = (ReservasPabellon) this.RPrepo.findById(id);
		this.RPrepo.delete(reserva);
		model.addAttribute("reservaP", this.RPrepo.findAll());
		return "index";
	}
}
