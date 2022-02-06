package cl.fpd.demostracion.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.fpd.demostracion.dao.TareaRepository;
import cl.fpd.demostracion.model.Tarea;

@Configuration
public class TareaConfig {

	@Bean
	CommandLineRunner commandLineRunner(TareaRepository tareaRepository) {

		return args -> {
			Tarea tarea1 = new Tarea("tarea1 P", Boolean.TRUE, LocalDate.of(2006, Month.JULY, 7));

			Tarea tarea2 = new Tarea("tarea2 D", Boolean.FALSE, LocalDate.of(1984, Month.JULY, 25));

			tareaRepository.saveAll(List.of(tarea1, tarea2));
		};

	}

}
