package com.martinez.app.escuela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martinez.app.escuela.models.Alumno;

public interface IAlumnosDao extends JpaRepository<Alumno, Long> { 
	//generico de que tipo y el tipo de dato del id
	//ya no es necesario definir los métodos porque JPArepository ya los tiene integrado
}
