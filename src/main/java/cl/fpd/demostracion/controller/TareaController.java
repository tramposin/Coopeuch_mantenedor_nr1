package cl.fpd.demostracion.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.fpd.demostracion.model.Tarea;
import cl.fpd.demostracion.service.TareaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "api/v1/tarea")
public class TareaController {

	private final TareaService tareaService;

	@Autowired	
	public TareaController(TareaService tareaService) {
		this.tareaService = tareaService;
	}

	@GetMapping
	@ApiOperation(value = "Busca tareas",
	notes="Busca las tareas almacenadas en la base de datos",
	response = Tarea.class)
	public List<Tarea> getTareas() { //@ApiParam(value ="valor value",required = true)
		return tareaService.getTareas();

	}

	@PostMapping
	@ApiOperation(value = "Agrega Nueva tarea",
	notes="Agrega nueva tarea a la base de datos",
	response = Tarea.class)	
	public void registerNewTarea(@RequestBody Tarea tarea) {
		tareaService.addNewTarea(tarea);
	}

	@DeleteMapping(path = "{tareaId}")
	@ApiOperation(value = "Elimina tarea por Id",
	notes="Elimina la tarea por Id especifico",
	response = Tarea.class)
	public void deleteTarea(@PathVariable("tareaId") Long tareaId) {
		tareaService.deleteTarea(tareaId);
	}
	
	
	@ApiOperation(value = "Actualiza tarea por Id",
	notes="Actualiza la tarea en la base de datos por medio del Id",
	response = Tarea.class)
	@PutMapping(path = "{tareaId}")
	public void updateTarea(
			@PathVariable("tareaId") Long tareaId, 
			@RequestParam(required = true) String descripcion,
			@RequestParam(required = true)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCreacion) {
		
		tareaService.updateTarea(tareaId,descripcion,fechaCreacion);
	}

}
