package com.example.ProyectoISW.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ProyectoISW.entity.SolicitudesPabellon;

public interface SolicitudPabellonRepo extends CrudRepository<SolicitudesPabellon, Long>{
	List<SolicitudesPabellon> findById(long id);
}
