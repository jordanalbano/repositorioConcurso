package proyecto.sistema.de.concursos.casos.de.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;

import proyecto.sistema.de.concursos.modelo.Concurso;
import proyecto.sistema.de.concursos.modelo.Participante;

public class ConcursoTest {
	@Test
	public void inscripcionEnConcurso() {
		// setup
		EnMemoriaRegistroDeInscripcion enMemoria = new EnMemoriaRegistroDeInscripcion();
		Concurso turismoAhora = new Concurso(1, "turismo", "ahora", LocalDate.of(2022, 3, 1), 30, enMemoria);
		Participante claudio = new Participante(2, "claudio", "sejac", 123312, 20);

		// testear- invocar para ver si anda o no
		turismoAhora.inscribirse(claudio);

		// verificar
		// boolean esta = turismoAhora.estaInscripto(claudio);
		Optional<String> stringEnMemoria = enMemoria.encontrar();
		assertEquals("claudio||2022-03-26||1", stringEnMemoria.get());
		// el primero es el esperado
	}

	/*
	 * @Test public void inscripcionElPrimerDia() { // setup Concurso
	 * aplicandoValores = new Concurso(1, "aplicando", "vaLores", LocalDate.of(2022,
	 * 3, 1), 30, new EnDiscoRegistroDeInscripcion()); Participante jordan = new
	 * Participante(2, "jordan", "albano", 123312, 20);
	 * 
	 * // testear- invocar para ver si anda o no
	 * aplicandoValores.inscribirse(jordan);
	 * 
	 * // verificar boolean resultadoEsperado = true;
	 * assertEquals(resultadoEsperado, aplicandoValores.estaInscripto(jordan));// el
	 * primero es el esperado }
	 * 
	 * @Test public void inscripcionFueraDeRango() { // setup Concurso
	 * cadenasUnidas= new Concurso(1, "cadenas", "unidas", LocalDate.of(2022, 3, 1),
	 * 30, new EnDiscoRegistroDeInscripcion()); Participante jonas = new
	 * Participante(1, "jonas", "bras", 123312, 20);
	 * 
	 * // testear- invocar para ver si anda o no cadenasUnidas.inscribirse(jonas);
	 * 
	 * // verificar boolean resultadoEsperado = true;
	 * assertEquals(resultadoEsperado, cadenasUnidas.estaEnRangoDeInscripcion());//
	 * el primero es el esperado
	 * 
	 * }
	 */

}
