package com.example.ProyectoISW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProyectoISW.entity.ReservasSillon;

public interface ReservaSillonRepo extends JpaRepository<ReservasSillon, Long> {
	List<ReservasSillon> findById(long id);
}
