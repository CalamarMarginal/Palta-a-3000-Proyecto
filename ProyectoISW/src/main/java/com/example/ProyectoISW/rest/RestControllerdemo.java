package com.example.ProyectoISW.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ProyectoISW.entity.ReservasPabellon;
import com.example.ProyectoISW.repository.ReservaPabellonRepo;

@RestController
@RequestMapping("/reservasP")
public class RestControllerdemo {

	@Autowired
	private ReservaPabellonRepo repo;
	@GetMapping
	public List<ReservasPabellon> listar(){
		return repo.findAll();
	}
	
	@PostMapping
	public void ingresar(@RequestBody ReservasPabellon reserva) {
		repo.save(reserva);
	}
	@PutMapping
	public void modificar(@RequestBody ReservasPabellon reserva) {
		repo.save(reserva);
	}
	@DeleteMapping(value = "/{id}")
	public void eliminarr(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
