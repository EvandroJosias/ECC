package com.ejsjose;

import com.ejsjose.domain.Presbiteros;
import com.ejsjose.repositories.PresbiterosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class PresbiterosCrudTest {

	private PresbiterosRepository presbiteroRepository;

	@BeforeEach
	void setUp() {
		presbiteroRepository = Mockito.mock(PresbiterosRepository.class);
	}

	@Test
	void testCreatePresbitero() {
		Presbiteros presbitero = new Presbiteros();
		presbitero.setFdl_name("João");

		when(presbiteroRepository.save(any(Presbiteros.class))).thenReturn(presbitero);

		Presbiteros saved = presbiteroRepository.save(presbitero);
		assertNotNull(saved);
		assertEquals("João", saved.getFdl_name());
	}

	@Test
	void testReadPresbitero() {
		Presbiteros presbitero = new Presbiteros();
		presbitero.setFdl_id(1L);
		presbitero.setFdl_name("Maria");

		when(presbiteroRepository.findById(1L)).thenReturn(Optional.of(presbitero));

		Optional<Presbiteros> found = presbiteroRepository.findById(1L);
		assertTrue(found.isPresent());
		assertEquals("Maria", found.get().getFdl_name());
	}

	@Test
	void testUpdatePresbitero() {
		Presbiteros presbitero = new Presbiteros();
		presbitero.setFdl_id(1L);
		presbitero.setFdl_name("Carlos");

		when(presbiteroRepository.save(any(Presbiteros.class))).thenReturn(presbitero);

		presbitero.setFdl_name("Carlos Atualizado");
		Presbiteros updated = presbiteroRepository.save(presbitero);

		assertEquals("Carlos Atualizado", updated.getFdl_name());
	}

	@Test
	void testDeletePresbitero() {
		doNothing().when(presbiteroRepository).deleteById(3L);

		presbiteroRepository.deleteById(3L);

		verify(presbiteroRepository, times(1)).deleteById(3L);
	}
}