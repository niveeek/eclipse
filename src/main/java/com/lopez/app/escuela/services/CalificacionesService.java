package com.lopez.app.escuela.services;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lopez.app.escuela.dao.IAlumnosDao;
import com.lopez.app.escuela.dao.ICalificacionesDao;
import com.lopez.app.escuela.dao.IMateriasDao;
import com.lopez.app.escuela.dtos.CalificacionCreateDTO;
import com.lopez.app.escuela.dtos.CalificacionesListDTO;
import com.lopez.app.escuela.models.Calificacion;
@Service
public class CalificacionesService implements IService<CalificacionesListDTO, CalificacionCreateDTO> {

	@Autowired
	private IAlumnosDao alumnosDao;
	
	@Autowired
	private IMateriasDao materiasDao;
	
	@Autowired
	private ICalificacionesDao calificacionesDao;
	
	@Override
	public CalificacionesListDTO create(CalificacionCreateDTO calificacionDTO) {
		// TODO Auto-generated method stub
		Calificacion calificacion = this.dtoToEntity(calificacionDTO);
		Calificacion calificacionNueva = calificacionesDao.save(calificacion);
		return this.entityToDto(calificacionNueva);
	}

	@Override
	public List<CalificacionesListDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalificacionesListDTO getById(long id) {
		// TODO Auto-generated method stub
		Calificacion calificacion = calificacionesDao.findById(id).orElseThrow( ()-> new RuntimeException());
		return this.entityToDto(calificacion);
	}

	@Override
	public CalificacionesListDTO update(CalificacionCreateDTO calificacionDTO, long id) {
		// TODO Auto-generated method stub
		Calificacion calificacion = calificacionesDao.findById(id).orElseThrow( ()-> new RuntimeException());
		calificacion.setId(calificacionDTO.getId());
		calificacion.setAlumno(alumnosDao.findById(calificacionDTO.getAlumno()).orElse(null));
		calificacion.setMateria(materiasDao.findById(calificacionDTO.getMateria()).orElse(null));
		calificacion.setCalificacion(calificacionDTO.getCalificacion());
		calificacion.setFechaRegistro(new Date() );
		Calificacion calificacionActualizada = calificacionesDao.save(calificacion);
		return this.entityToDto(calificacionActualizada);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Calificacion calificacion = calificacionesDao.findById(id).orElseThrow( ()-> new RuntimeException());
		calificacionesDao.delete(calificacion);
	}
	
	public Calificacion dtoToEntity(CalificacionCreateDTO calificacionDTO) {
		Calificacion calificacion = new Calificacion();
		calificacion.setAlumno(alumnosDao.findById(calificacionDTO.getAlumno()).orElse(null));
		calificacion.setMateria(materiasDao.findById(calificacionDTO.getMateria()).orElse(null));
		calificacion.setCalificacion(calificacionDTO.getCalificacion());
		calificacion.setFechaRegistro(new Date());
		
		return calificacion;
	}
	
	public CalificacionesListDTO entityToDto(Calificacion calificacion) {
		CalificacionesListDTO calificacionesDTO = new CalificacionesListDTO();
		calificacionesDTO.setId(calificacion.getId());
		calificacionesDTO.setCalificacion(calificacion.getCalificacion());
		calificacionesDTO.setAlumno(calificacion.getAlumno().getNombre());
		calificacionesDTO.setMateria(calificacion.getMateria().getNombre());
		calificacionesDTO.setFechaRegistro(calificacion.getFechaRegistro());
		
		return calificacionesDTO;
	}

}
