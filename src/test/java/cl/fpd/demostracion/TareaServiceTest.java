package cl.fpd.demostracion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.fpd.demostracion.dao.TareaRepository;
import cl.fpd.demostracion.model.Tarea;
import cl.fpd.demostracion.service.TareaService;

@ExtendWith(MockitoExtension.class)
class TareaServiceTest {

	@Mock
	private TareaRepository tareaRepository;
	private TareaService underTest;

	@BeforeEach
	void setUp() {
		underTest = new TareaService(tareaRepository);
	}

	@Test
	void testGetTareas() {
		// when
		underTest.getTareas();

		// then
		verify(tareaRepository).findAll();
	}
	
	@Test
	void contextLoads() {
	}


	@Test
	void testAddNewTarea() {

		// given
		Tarea tareaTest = new Tarea("tarea test", Boolean.TRUE, LocalDate.of(2000, Month.JULY, 1));
		// when
		underTest.addNewTarea(tareaTest);

		// then
		ArgumentCaptor<Tarea> tareArgumentCaptor = ArgumentCaptor.forClass(Tarea.class);

		verify(tareaRepository).save(tareArgumentCaptor.capture());
		Tarea captureTarea = tareArgumentCaptor.getValue();
		assertThat(captureTarea).isEqualTo(tareaTest);

	}

	@Test
	@Disabled
	void testAddNewTareaThrow() {

		// given
		Tarea tareaTest = new Tarea("tarea test", Boolean.TRUE, LocalDate.of(2000, Month.JULY, 1));

		given(tareaRepository.findTareaById(tareaTest.getId()).isPresent()).willReturn(true);

		// when
		// then
		assertThatThrownBy(() -> underTest.addNewTarea(tareaTest)).isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("ID " + tareaTest.getId() + " existente");

		verify(tareaRepository, never()).save(any());

	}

	@Test
	@Disabled
	void testDeleteTarea() {

		// given
		Long tareaID = 1L;
		Tarea tareaTest = new Tarea("tarea test", Boolean.TRUE, LocalDate.of(2000, Month.JULY, 1));
		// when
		underTest.deleteTarea(tareaID);

		// then
		ArgumentCaptor<Tarea> tareArgumentCaptor = ArgumentCaptor.forClass(Tarea.class);
		verify(tareaRepository).deleteById(tareaID);
		Tarea captureTarea = tareArgumentCaptor.getValue();
		assertThat(captureTarea).isEqualTo(tareaTest);
	}

	@Test
	@Disabled
	void testUpdateTarea() {

		// given
		Tarea tareaTest = new Tarea("tarea test update", Boolean.TRUE, LocalDate.of(2000, Month.JULY, 1));
		Long tareaID = 1L;
		String tareaDescripcion = "tarea test update";
		LocalDate fechaCreacion = LocalDate.of(2000, Month.JULY, 1);
		// when
		underTest.updateTarea(tareaID, tareaDescripcion, fechaCreacion);

		// then
		ArgumentCaptor<Tarea> tareArgumentCaptor = ArgumentCaptor.forClass(Tarea.class);

		verify(tareaRepository).save(tareArgumentCaptor.capture());
		Tarea captureTarea = tareArgumentCaptor.getValue();
		assertThat(captureTarea).isEqualTo(tareaTest);
	}

	@Test
	@Disabled
	void testUpdateTareaThrow() {

		// given
		Tarea tareaTest = new Tarea("tarea test", Boolean.TRUE, LocalDate.of(2000, Month.JULY, 1));
		Long tareaID = 1L;

		// when
		// then
		assertThatThrownBy(() -> underTest.addNewTarea(tareaTest)).isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("Tarea con id " + tareaID + " no existe");

		verify(tareaRepository, never()).save(any());

	}

}
