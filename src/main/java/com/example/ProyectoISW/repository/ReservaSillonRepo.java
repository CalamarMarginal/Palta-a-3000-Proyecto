package com.example.ProyectoISW.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ProyectoISW.entity.ReservasSillon;

public interface ReservaSillonRepo extends CrudRepository<ReservasSillon, Long> {
	List<ReservasSillon> findById(long id);
}
