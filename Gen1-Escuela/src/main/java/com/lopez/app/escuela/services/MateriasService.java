package com.martinez.app.escuela.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.app.escuela.dao.IMateriasDao;
import com.martinez.app.escuela.dtos.MateriaCreateDTO;
import com.martinez.app.escuela.dtos.MateriaListDTO;
import com.martinez.app.escuela.models.Materia;

@Service
public class MateriasService implements IService<MateriaListDTO, MateriaCreateDTO> {
	
	@Autowired
	private IMateriasDao materiasDao;

	@Override
	public MateriaListDTO create(MateriaCreateDTO materiaDTO) {
		// TODO Auto-generated method stub
		Materia materia = this.dtoToEntity(materiaDTO);
		Materia materiaNueva = materiasDao.save(materia);
		return this.entityToDto(materiaNueva);
	}

	@Override
	public List<MateriaListDTO> getAll() {
		// TODO Auto-generated method stub
		List<Materia> materias = materiasDao.findAll();
		List<MateriaListDTO> contenido = materias.stream()
				.map(materia -> this.entityToDto(materia)).collect(Collectors.toList());
		
		return contenido;
	}

	@Override
	public MateriaListDTO getById(long id) {
		// TODO Auto-generated method stub
		Materia materia = materiasDao.findById(id).orElseThrow( ()-> new RuntimeException() );
		return this.entityToDto(materia);
	}

	@Override
	public MateriaListDTO update(MateriaCreateDTO materiaDTO, long id) {
		// TODO Auto-generated method stub
		Materia materia = materiasDao.findById(id).orElseThrow( ()-> new RuntimeException() );
		materia.setId(materiaDTO.getId());
		materia.setNombre(materiaDTO.getNombre());
		materia.setActivo(materiaDTO.getActivo());
		
		Materia materiaActualizada = materiasDao.save(materia);
		return this.entityToDto(materiaActualizada);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Materia materia = materiasDao.findById(id).orElseThrow( ()-> new RuntimeException() );
		
		materiasDao.delete(materia);
	}
	
	public Materia dtoToEntity(MateriaCreateDTO materiaDTO) {
		Materia materia = new Materia();
		materia.setNombre(materiaDTO.getNombre());
		materia.setId(materiaDTO.getId());
		materia.setActivo(materiaDTO.getActivo());
		
		return materia;
	}
	
	public MateriaListDTO entityToDto(Materia materia) {
		MateriaListDTO materiaDTO = new MateriaListDTO();
		materiaDTO.setId(materia.getId());
		materiaDTO.setNombre(materia.getNombre());
		materiaDTO.setActivo(materia.getActivo());
		
		return materiaDTO;
	}

}
