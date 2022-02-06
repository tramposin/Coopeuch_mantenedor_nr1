package cl.fpd.demostracion.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.fpd.demostracion.dao.TareaRepository;
import cl.fpd.demostracion.model.Tarea;

@Service
public class TareaService {

	private final TareaRepository tareaRepository;

	@Autowired
	public TareaService(TareaRepository tareaRepository) {
		this.tareaRepository = tareaRepository;
	}

	//-------------------------------------------------------------------------------------------
	//
	//	Trae Tareas por  Id
	//
	//-------------------------------------------------------------------------------------------
	
	public List<Tarea> getTareas() {
		return tareaRepository.findAll();

	}
	
	//-------------------------------------------------------------------------------------------
	//
	//	agrega nueva Tarea a la bd
	//
	//-------------------------------------------------------------------------------------------
	public void addNewTarea(Tarea tarea) {
		Optional<Tarea> tareaOptional = tareaRepository.findTareaById(tarea.getId());
		Boolean existeTarea = tareaOptional.isPresent();
		if (existeTarea) {
			throw new IllegalStateException("ID " + tarea.getId() +" existente");
		}
		tareaRepository.save(tarea);

	}
	
	
	//-------------------------------------------------------------------------------------------
	//
	//	Elimina Tarea por ID de la BD
	//
	//-------------------------------------------------------------------------------------------

	public void deleteTarea(Long tareaID) {

		boolean exist = tareaRepository.existsById(tareaID);
		if (!exist) {

			throw new IllegalStateException("Tarea con id " + tareaID + " no existe");
		}
		tareaRepository.deleteById(tareaID);

	}
	
	
	
	//-------------------------------------------------------------------------------------------
	//
	//	Actualiza Tarea en BD
	//
	//-------------------------------------------------------------------------------------------

	@Transactional
	public void updateTarea(Long tareaID, String descripcion, LocalDate fechaCreacion) {
		
		Tarea tarea = tareaRepository.findById(tareaID)
				.orElseThrow(() -> new IllegalStateException("Tarea con id " + tareaID + " no existe"));

		if (descripcion != null && descripcion.length() > 0 && !Objects.equals(tarea.getDescripcion(), descripcion)) {
			tarea.setDescripcion(descripcion);
		}

		tarea.setFechaCreacion(fechaCreacion);

	}

 
}
