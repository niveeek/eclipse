package com.lopez.app.escuela.dtos;
public class AlumnoCreateDTO {
	//DECLARACION DE ATRIBUTOS
	private Long id;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private Integer activo;
	//CONSTRUCTOR SIN ARGUMENTOS
	public AlumnoCreateDTO() {
		super();
	}
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp_paterno() {
		return ap_paterno;
	}
	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}
	public String getAp_materno() {
		return ap_materno;
	}
	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
}