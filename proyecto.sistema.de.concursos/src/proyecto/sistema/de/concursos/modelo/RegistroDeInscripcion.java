package proyecto.sistema.de.concursos.modelo;

import java.util.Optional;

public interface RegistroDeInscripcion {
	void registrar(String registro);

	// String encontrar();

	Optional<String> encontrar();
}
