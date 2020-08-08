package com.example.ProyectoISW.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ProyectoISW.entity.SolicitudesSillon;

public interface SolicitudSillonRepo extends CrudRepository<SolicitudesSillon, Long>{
	List<SolicitudesSillon> findById(long id);
}
