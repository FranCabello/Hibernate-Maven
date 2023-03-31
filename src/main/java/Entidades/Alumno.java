package Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Anotaciones de Hibernate
@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@Column(name = "alumno_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
	// Atributos
	private long id;
	private String nombre;
	private String apellidos;
	private String curso;
	private int asignaturas;
	private int edad;

	// Constructor
	public Alumno(String nombre, String apellidos, String curso, int asignaturas, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
		this.asignaturas = asignaturas;
		this.edad = edad;
	}

	// Constructor por defecto
	public Alumno() {

	}

	// Getters and setters
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
