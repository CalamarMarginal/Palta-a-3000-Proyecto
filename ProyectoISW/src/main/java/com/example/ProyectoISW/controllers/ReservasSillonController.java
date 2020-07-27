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

import com.example.ProyectoISW.entity.ReservasSillon;
import com.example.ProyectoISW.repository.ReservaSillonRepo;

@Controller
@RequestMapping("/reservasillon")
public class ReservasSillonController {


		@Autowired
		private ReservaSillonRepo RSrepo;
		
		@GetMapping("showForm")
		public String ShowReservaSForm(){
			return "add-reservasillon";
		}
		
		@GetMapping("list")
		public String reservas(Model model) {
			model.addAttribute("reservasS", this.RSrepo.findAll());
			return "index";
		}
		
		@PostMapping("add")
		public String addReserva(/*@Valid*/ ReservasSillon reserva, BindingResult result, Model model) {
			if(result.hasErrors()){
				return "add-reservasillon";
			}
			this.RSrepo.save(reserva);
			return "redirect:list";
		}
		
		@GetMapping("edit/{id}")
		public String showUpdateForm(@PathVariable("id") long id, Model model) {
			ReservasSillon reserva = (ReservasSillon) this.RSrepo.findById(id);
			model.addAttribute("reservaS", reserva);
			return "update-reservaS";
		}
		
		@PostMapping("update/{id}")
		public String updateCar(@PathVariable("id") long id, ReservasSillon reserva, BindingResult result, Model model) {
			if(result.hasErrors()) {
				reserva.setId(id);
				return "update-reservaS";
			}
			RSrepo.save(reserva);
			model.addAttribute("reservasS", this.RSrepo.findAll());
			return "index";
		}
		
		@DeleteMapping("delete/{id}")
		public String deleteCar(@PathVariable("id") long id, Model model) {
			ReservasSillon reserva = (ReservasSillon) this.RSrepo.findById(id);
			this.RSrepo.delete(reserva);
			model.addAttribute("reservasS", this.RSrepo.findAll());
			return "index";
		}

}
