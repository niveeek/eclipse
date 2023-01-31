package com.lopez.app.escuela.dtos;
import java.util.Date;
public class MateriaDTO {
	//DECLARACION DE ATRIBUTOS
	private Long id;
	private Long idReg;
	private String materia;
	private Double calificacion;
	private Date fechaRegistro;
	//CONSTRUCTOR SIN ARGUMENTO
	public MateriaDTO() {
		super();
	}
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdReg() {
		return idReg;
	}
	public void setIdReg(Long idReg) {
		this.idReg = idReg;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public Double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}