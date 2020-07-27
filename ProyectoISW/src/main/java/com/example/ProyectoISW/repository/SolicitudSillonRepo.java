package com.example.ProyectoISW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoISW.entity.SolicitudesSillon;

public interface SolicitudSillonRepo extends JpaRepository<SolicitudesSillon, Long>{
	List<SolicitudesSillon> findById(long id);
}
