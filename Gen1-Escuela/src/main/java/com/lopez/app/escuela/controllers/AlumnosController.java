package com.martinez.app.escuela.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinez.app.escuela.dtos.AlumnoCreateDTO;
import com.martinez.app.escuela.dtos.AlumnoListDTO;
import com.martinez.app.escuela.services.IService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnosController {
	
	@Autowired
	private IService<AlumnoListDTO, AlumnoCreateDTO> alumnosService;
	
	@GetMapping
	public List<AlumnoListDTO> getListaAlumnos(){
		return alumnosService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlumnoListDTO> getAlumnoById(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(alumnosService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<AlumnoListDTO> guardarAlumno(@Valid @RequestBody AlumnoCreateDTO alumnoDTO){
		return new ResponseEntity<>(alumnosService.create(alumnoDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AlumnoListDTO> actualizarAlumno(@Valid @RequestBody AlumnoCreateDTO alumnoDTO, @PathVariable(name = "id") long id){
		AlumnoListDTO alumnoRespuesta = alumnosService.update(alumnoDTO, id);
		return new ResponseEntity<>(alumnoRespuesta, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> eliminarAlumno(@PathVariable(name = "id") long id){
		Map<String, String> mapa = new HashMap<>();	
		mapa.put("message", "Alumno eliminado con exito");
		alumnosService.delete(id);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}
}
