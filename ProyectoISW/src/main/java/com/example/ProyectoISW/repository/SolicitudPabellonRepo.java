package com.example.ProyectoISW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProyectoISW.entity.SolicitudesPabellon;

public interface SolicitudPabellonRepo extends JpaRepository<SolicitudesPabellon, Long>{
	List<SolicitudesPabellon> findById(long id);
}
