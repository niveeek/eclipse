package com.martinez.app.escuela.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.app.escuela.dao.IAlumnosDao;
import com.martinez.app.escuela.dtos.AlumnoCreateDTO;
import com.martinez.app.escuela.dtos.AlumnoListDTO;
import com.martinez.app.escuela.dtos.MateriaDTO;
import com.martinez.app.escuela.models.Alumno;
import com.martinez.app.escuela.models.Calificacion;

@Service
public class AlumnosService implements IService<AlumnoListDTO, AlumnoCreateDTO> {
	
	@Autowired
	private IAlumnosDao alumnosDao;

	@Override
	public AlumnoListDTO create(AlumnoCreateDTO alumnoDTO) {
		Alumno alumno = this.dtoToEntity(alumnoDTO);
		Alumno alumnoNuevo = alumnosDao.save(alumno);
		//return this.entityToDtoCreate(alumnoNuevo);
		return this.entityToDto(alumnoNuevo);
	}

	@Override
	public List<AlumnoListDTO> getAll() {
		List<Alumno> listaAlumnos = alumnosDao.findAll();
		List<AlumnoListDTO> contenido = listaAlumnos.stream()
				.map(alumno -> this.entityToDto(alumno)).collect(Collectors.toList());
		return contenido;
	}

	@Override
	public AlumnoListDTO getById(long id) {
		Alumno alumno = alumnosDao.findById(id).orElseThrow( ()-> new RuntimeException() );
		return this.entityToDto(alumno);
	}

	@Override
	public AlumnoListDTO update(AlumnoCreateDTO alumnoDTO, long id) {
		Alumno alumno = alumnosDao.findById(id).orElseThrow(()-> new RuntimeException());
		alumno.setId(alumnoDTO.getId());
		alumno.setNombre(alumnoDTO.getNombre());
		alumno.setAp_paterno(alumnoDTO.getAp_paterno());
		alumno.setAp_materno(alumnoDTO.getAp_materno());
		alumno.setActivo(alumnoDTO.getActivo());
		Alumno alumnoActualizado = alumnosDao.save(alumno);
		return this.entityToDto(alumnoActualizado);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Alumno alumno = alumnosDao.findById(id).orElseThrow(()->new RuntimeException());
		alumnosDao.delete(alumno);
		
	}
	
	public Alumno dtoToEntity(AlumnoCreateDTO alumnoDTO) {
		Alumno alumno = new Alumno();
		alumno.setId(alumnoDTO.getId());
		alumno.setNombre(alumnoDTO.getNombre());
		alumno.setAp_paterno(alumnoDTO.getAp_paterno());
		alumno.setAp_materno(alumnoDTO.getAp_materno());
		alumno.setActivo(alumnoDTO.getActivo());
		return alumno;
	}
	
	public AlumnoListDTO entityToDto(Alumno alumno) {
		Double suma = 0D;
		AlumnoListDTO alumnoDTO = new AlumnoListDTO();
		alumnoDTO.setId(alumno.getId());
		alumnoDTO.setNombre(alumno.getNombre());
		alumnoDTO.setAp_paterno(alumno.getAp_paterno());
		alumnoDTO.setAp_materno(alumno.getAp_materno());
		alumnoDTO.setActivo(alumno.getActivo());
		alumnoDTO.setPromedio(suma);
		if (alumno.getCalificaciones() != null && alumno.getCalificaciones().size() > 0) {
			for (Calificacion ahm: alumno.getCalificaciones()) {
				MateriaDTO m = new MateriaDTO();
				m.setIdReg(ahm.getId());
				m.setId(ahm.getMateria().getId());
				m.setMateria(ahm.getMateria().getNombre());
				m.setCalificacion(ahm.getCalificacion());
				m.setFechaRegistro(ahm.getFechaRegistro());
				alumnoDTO.addMateria(m);
				suma+=ahm.getCalificacion();
			}
			alumnoDTO.setPromedio(suma / alumno.getCalificaciones().size());
		}
		return alumnoDTO;
	}
	
}
