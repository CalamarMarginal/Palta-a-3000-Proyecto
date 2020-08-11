package com.example.ProyectoISW.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SolicitudesSillon {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="idPaciente")
	private long idPaciente;
	@Column(name="Descripción")
	private String descripcion;
	
	public SolicitudesSillon() {
	}
	
	public SolicitudesSillon(long idPaciente, String descripcion) {
		this.idPaciente=idPaciente;
		this.descripcion=descripcion;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public long getIdPaciente() {
		return idPaciente;
	}
	
	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
}
