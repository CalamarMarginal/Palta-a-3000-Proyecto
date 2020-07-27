package com.example.ProyectoISW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoISW.entity.ReservasPabellon;


public interface ReservaPabellonRepo  extends JpaRepository<ReservasPabellon, Long> {
	List<ReservasPabellon> findById(long id);
}
