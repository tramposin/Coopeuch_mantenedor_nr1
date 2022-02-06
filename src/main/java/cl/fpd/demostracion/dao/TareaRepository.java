package cl.fpd.demostracion.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.fpd.demostracion.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

	@Query("SELECT t FROM Tarea t WHERE t.id = ?1")
	Optional<Tarea> findTareaById(Long id);

}
