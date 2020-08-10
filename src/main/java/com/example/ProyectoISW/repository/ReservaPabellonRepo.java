package com.example.ProyectoISW.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.ProyectoISW.entity.ReservasPabellon;


public interface ReservaPabellonRepo  extends CrudRepository<ReservasPabellon, Long> {
	List<ReservasPabellon> findById(long id);
}
