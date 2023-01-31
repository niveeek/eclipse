package com.lopez.app.escuela.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lopez.app.escuela.models.Materia;
public interface IMateriasDao extends JpaRepository<Materia,Long>{

}