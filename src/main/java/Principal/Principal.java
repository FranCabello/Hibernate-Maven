package Principal;

import java.nio.channels.NonReadableChannelException;
import java.util.List;

import Entidades.Alumno;
import Managers.Acceso;
import Managers.ManagerPrincipal;

public class Principal {

	public static void main(String args[]) {
		// Abrimos la sesi�n
		ManagerPrincipal.setup();
		// Introducimos alumnos de ejemplo
		Alumno a = new Alumno("Paco", "Perez", "DAM", 5, 25);
		Alumno b = new Alumno("Pedro", "S�nchez", "DAW", 2, 40);
		// Introducimos alumnos por pantalla
		Acceso managerAlumno = new Acceso();
		managerAlumno.create();

		Acceso.insertarAlumno(a);
		Acceso.insertarAlumno(b);
		// Listamos los alumnos creados
		Acceso.listarAlumnos();
		// Cerramos la sesi�n
		ManagerPrincipal.exit();
	}
}