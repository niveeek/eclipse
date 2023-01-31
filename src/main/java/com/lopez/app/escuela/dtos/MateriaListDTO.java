package com.lopez.app.escuela.dtos;
public class MateriaListDTO {
	//ATRIBUTOS
	private Long id;
	private String nombre;
	private Integer activo;
	//CONSTRUCTOR SIN ARGUMENTOS
	public MateriaListDTO() {
		super();
	}
	//CONSTRUCTOR CON ARGUMENTOS
	public MateriaListDTO(Long id, String nombre, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
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
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
}