package com.lopez.app.escuela.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table (name="materias")
public class Materia {
	//DECLARACION DE ATRIBUTOS Y TABLAS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	@Column(name="id_materia")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="activo")
	private Integer activo;
	//CONSTRUCTOR SIN ARGUMENTOS
	public Materia() {
		super();
	}
	//CONSTRUCTOR CON ARGUMENTOS
	public Materia(Long id, String nombre, Integer activo) {
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