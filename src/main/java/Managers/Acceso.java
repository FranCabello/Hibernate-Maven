package Managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidades.Alumno;

public class Acceso {
	// Método para insertar alumnos en la base de datos
	public static void insertarAlumno(Alumno a) {

		String nombre = a.getNombre();
		String apellidos = a.getApellidos();
		String curso = a.getCurso();
		int asignaturas = a.getAsignaturas();
		int edad = a.getEdad();

		Session session = ManagerPrincipal.sessionFactory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		session.close();

	}

	// Método para listar los alumnos de la base de datos
	public static void listarAlumnos() {
		Session session = ManagerPrincipal.sessionFactory.openSession();
		List<Alumno> alumnos = session.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.getNombre() + " " + alumno.getApellidos() + ", " + alumno.getCurso() + ", "
					+ alumno.getAsignaturas() + ", " + alumno.getEdad());
		}
	}

	// Método para insertar alumnos por pantalla
	public static void create() {

		Scanner sc = new Scanner(System.in);
		Alumno alumno;
		boolean crear = true;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		while (crear) {

			alumno = new Alumno();

			System.out.println("Introduce el nombre del alumno: ");
			alumno.setNombre(sc.nextLine());
			System.out.println("Introduce los apellidos del alumno: ");
			alumno.setApellidos(sc.nextLine());
			System.out.println("Introduce el curso del alumno: ");
			alumno.setCurso(sc.nextLine());
			System.out.println("Introduce las asignaturas del alumno: ");
			alumno.setAsignaturas(sc.nextInt());
			System.out.println("Introduce la edad del alumno: ");
			alumno.setEdad(sc.nextInt());
			sc.nextLine();

			alumnos.add(alumno);

			System.out.println("Si quiere añadir otro, teclee 'si': ");
			String letra = sc.nextLine();

			if (letra.equals("si")) {
				crear = true;
			} else {
				crear = false;
			}

			Session session = ManagerPrincipal.sessionFactory.openSession();
			session.beginTransaction();
			session.save(alumno);
			session.getTransaction().commit();
			session.close();

		}
		sc.close();

	}

}