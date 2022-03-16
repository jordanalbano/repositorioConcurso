package proyecto.sistema.de.concursos.modelo;

import java.time.LocalDate;

import java.util.ArrayList;
import proyecto.sistema.de.concursos.exceptions.ExcepcionPorNoEstarEnRango;
import proyecto.sistema.de.concursos.exceptions.ExcepcionPorParticipanteInscripto;

public class Concurso {
	private Integer codigoDeConcurso;
	private String descripcion;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinDeInscripcion;
	private ArrayList<Participante> participantesInscriptos = new ArrayList<Participante>();
	public Concurso(Integer codigoDeConcurso, String descripcion, String nombre, LocalDate fechaInicioDeInscripcion, LocalDate fechaFinInscripcion) {
		this.codigoDeConcurso = codigoDeConcurso;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.fechaFinDeInscripcion = fechaFinInscripcion;
		this.fechaInicioInscripcion = fechaInicioDeInscripcion;
		
	}
	private Integer codigoDeConcurso() {
		return this.codigoDeConcurso;
	}
	private String descripcion(){
		return this.descripcion;
	}
	private String nombre() {
		return this.nombre;
	}
	public boolean equals(Concurso otroConcurso) {
		return this.codigoDeConcurso.equals(otroConcurso.codigoDeConcurso());
		
	}
	public String toString() {
		return "Nombre: " + this.nombre
				+ "Descripcion: " + this.descripcion
				+ "Codigo De Concurso: " + this.codigoDeConcurso;
	}	
	public void inscribirse(Participante participante) throws ExcepcionPorParticipanteInscripto, ExcepcionPorNoEstarEnRango {
		if(this.participantesInscriptos.size() != 0) {
			System.out.println("entra aca");
			if(estaInscripto(participante)) {
				throw new ExcepcionPorParticipanteInscripto("El Participante Ya Esta Inscripto");
			}
			if(!estaEnRangoDeInscripcion()) {
				throw new ExcepcionPorNoEstarEnRango("No Esta En El Rango De Inscripcion");
			}
			if(inscribioElPrimerDia()) {
				participante.agregarPuntos(10);
			}
			
		}
		this.participantesInscriptos.add(participante);

		
	}
	
	public boolean inscribioElPrimerDia() {
		LocalDate ld = LocalDate.now();

		return fechaInicioInscripcion.equals(ld);
	}
	
	public boolean estaEnRangoDeInscripcion() {
		LocalDate fechaActual = LocalDate.now();
		return this.fechaInicioInscripcion.isBefore(fechaActual) && this.fechaFinDeInscripcion.isAfter(fechaActual);
	}
	
	public boolean estaInscripto(Participante participante) {
		return this.participantesInscriptos.stream().anyMatch(p->participante.equals(participante));
	}
}
