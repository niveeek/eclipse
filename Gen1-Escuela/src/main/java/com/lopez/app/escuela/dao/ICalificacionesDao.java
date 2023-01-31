package com.martinez.app.escuela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martinez.app.escuela.models.Calificacion;

public interface ICalificacionesDao extends JpaRepository<Calificacion, Long> {

}
