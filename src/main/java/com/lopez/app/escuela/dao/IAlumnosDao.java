package com.lopez.app.escuela.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lopez.app.escuela.models.Alumno;
public interface IAlumnosDao extends JpaRepository<Alumno,Long>{
	
}