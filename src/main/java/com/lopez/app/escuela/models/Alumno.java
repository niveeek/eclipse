package com.lopez.app.escuela.models;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="alumnos")
public class Alumno {
	//DECLARACION DE ATRIBUTOS Y TABLAS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ2")
	@SequenceGenerator(sequenceName = "customer_seq2", allocationSize = 1, name = "CUST_SEQ2")
	@Column(name="id_alumno")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="ap_paterno")
	private String ap_paterno;
	@Column(name="ap_materno")
	private String ap_materno;
	@Column(name="activo")
	private Integer activo;
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
	private Set<Calificacion> calificaciones;
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public Set<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(Set<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
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
	//CONSTRUCTOR CON ARGUMENTOS
	public Alumno(Long id, String nombre, String ap_paterno, String ap_materno, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ap_paterno = ap_paterno;
		this.ap_materno = ap_materno;
		this.activo = activo;
	}
	public Alumno() {
		super();
	}
}