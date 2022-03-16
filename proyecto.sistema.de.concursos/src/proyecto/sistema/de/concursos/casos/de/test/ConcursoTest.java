package proyecto.sistema.de.concursos.casos.de.test;



import static org.junit.jupiter.api.Assertions.assertEquals;



import java.time.LocalDate;


import org.junit.Test;

import proyecto.sistema.de.concursos.modelo.Concurso;
import proyecto.sistema.de.concursos.modelo.Participante;



public class ConcursoTest {
	@Test
	public void inscripcionEnConcurso() {
		//setup
		Concurso miConcurso = new Concurso(1,"des","nombre", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 4, 25));
		Participante participante = new Participante(1,"jo","as",123312, 20);
		
		//testear- invocar para ver si anda o no
		miConcurso.inscribirse(participante);
		
		//verificar
		boolean esta = miConcurso.estaInscripto(participante);
		assertEquals(true, esta);//el primero es el esperado
	}
	@Test
	public void inscripcionElPrimerDia() {
		//setup
				Concurso miConcurso = new Concurso(1,"des","nombre", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 4, 25));
				Participante participante = new Participante(1,"jo","as",123312, 20);
				
				//testear- invocar para ver si anda o no
				miConcurso.inscribirse(participante);
				
				//verificar
				boolean resultadoEsperado = true;
				assertEquals(resultadoEsperado, miConcurso.estaInscripto(participante));//el primero es el esperado
	}
	
	@Test
	public void inscripcionFueraDeRango() {
		//setup
				Concurso miConcurso = new Concurso(1,"des","nombre", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 3, 2));
				Participante participante = new Participante(1,"jo","as",123312, 20);
				
				//testear- invocar para ver si anda o no
				miConcurso.inscribirse(participante);
				
				//verificar
				boolean resultadoEsperado = true;
				assertEquals(resultadoEsperado, miConcurso.estaEnRangoDeInscripcion());//el primero es el esperado
				
	}



	

}
