package Principal;

import java.nio.channels.NonReadableChannelException;
import java.util.List;

import Entidades.Alumno;
import Managers.Acceso;
import Managers.ManagerPrincipal;

public class Principal {

	public static void main(String args[]) {
		// Abrimos la sesión
		ManagerPrincipal.setup();
		// Introducimos alumnos de ejemplo
		Alumno a = new Alumno("Paco", "Perez", "DAM", 5, 25);
		Alumno b = new Alumno("Pedro", "Sánchez", "DAW", 2, 40);
		// Introducimos alumnos por pantalla
		Acceso managerAlumno = new Acceso();
		managerAlumno.create();

		Acceso.insertarAlumno(a);
		Acceso.insertarAlumno(b);
		// Listamos los alumnos creados
		Acceso.listarAlumnos();
		// Cerramos la sesión
		ManagerPrincipal.exit();
	}
}