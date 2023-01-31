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

import com.martinez.app.escuela.dtos.MateriaCreateDTO;
import com.martinez.app.escuela.dtos.MateriaListDTO;
import com.martinez.app.escuela.services.IService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materias")
@CrossOrigin(origins = "*")
public class MateriasController {
	@Autowired
	private IService<MateriaListDTO, MateriaCreateDTO> materiasService;
	
	@GetMapping
	public List<MateriaListDTO> getListaMaterias(){
		return materiasService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MateriaListDTO> getMateriaById(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(materiasService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<MateriaListDTO> guardarMateria(@Valid @RequestBody MateriaCreateDTO materiaDTO){
		return new ResponseEntity<>(materiasService.create(materiaDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MateriaListDTO> actualizarMateria(@Valid @RequestBody MateriaCreateDTO materiaDTO, @PathVariable(name = "id") long id){
		MateriaListDTO materiaRespuesta = materiasService.update(materiaDTO, id);
		return new ResponseEntity<>(materiaRespuesta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> eliminarMateria(@PathVariable(name = "id") long id){
		Map<String, String> mapa = new HashMap<>();
		mapa.put("message", "Materia eliminada correctamente");
		materiasService.delete(id);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}
	
	
}
