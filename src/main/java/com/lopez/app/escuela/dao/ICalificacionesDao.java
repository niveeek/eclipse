package com.lopez.app.escuela.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lopez.app.escuela.models.Calificacion;
public interface ICalificacionesDao extends JpaRepository<Calificacion, Long> {

}