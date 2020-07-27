package com.example.ProyectoISW.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ReservasSillon {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="idSillon")
	private long idSillon;
	@Column(name="idSolicitud")
	private long idSolicitud;
	@Column(name="Reservado")
	private boolean reservado;
	@Column(name="Horario")
	private String horario;
	
	public ReservasSillon(){
		
	}
	
	public ReservasSillon(long idSillon, long idSolicitud, boolean Reservado, String descripcion, String horario) {
		this.idSillon=idSillon;
		this.idSolicitud=idSolicitud;
		this.reservado=Reservado;
		this.horario=horario;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getIdSillon() {
		return idSillon;
	}
	
	public void setIdSillon(long idSillon) {
		this.idSillon = idSillon;
	}
	
	public long getIdSolicitud() {
		return idSolicitud;
	}
	
	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	public boolean getReservado() {
		return reservado;
	}
	
	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}

}
