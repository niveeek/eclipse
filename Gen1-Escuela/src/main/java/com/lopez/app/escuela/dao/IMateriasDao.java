package com.martinez.app.escuela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martinez.app.escuela.models.Materia;

public interface IMateriasDao extends JpaRepository<Materia, Long> {

}
