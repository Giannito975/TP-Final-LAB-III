package Clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.DniAlreadyExistException;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private char sexo; // F (femenino), M (masculino)
	private String domicilio; // Calle seguida de la altura
	private String correoElectronico;
	private String dni;
	private String nroTelefono;
	private static final List<String> usedDni = new ArrayList<>();

	// Constructor vacío
	public Persona() {
		this.nombre = "";
		this.apellido = "";
		this.fechaNacimiento = "";
		this.sexo = ' ';
		this.domicilio = "";
		this.correoElectronico = "";
		this.dni = "";
		this.nroTelefono = "";
	}

	// Constructor con parámetros
	public Persona(String nombre, String apellido, String fechaNacimiento, char sexo, String domicilio,
			String correoElectronico, String dni, String nroTelefono) throws DniAlreadyExistException {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.domicilio = domicilio;
		this.correoElectronico = correoElectronico;
		if (checkDni(dni)) {
			setDni(dni);
			usedDni.add(dni);
		}
		this.nroTelefono = nroTelefono;
	}

	// Getters & Setters

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getDni() {
		return dni;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}
	// OTROS MÉTODOS //

	@Override
	public String toString() {
		return "-------------------------------------\n" + "Nombre: " + getNombre() + "\nApellido: " + getApellido()
				+ "\nFecha de nacimiento: " + getFechaNacimiento() + "\nSexo: " + getSexo() + "\nDomicilio: "
				+ getDomicilio() + "\nCorreo electrónica: " + getCorreoElectronico() + "\nDNI: " + getDni()
				+ "\nNúmero de teléfono: " + getNroTelefono() + "\n";
	}

	// Corroboración para que no se repita la persona
	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			if (obj instanceof Persona) {
				if (this.dni == ((Persona) obj).getDni()) {
					return true;
				}
			}
		}
		return false;
	}

	// Otra manera de corroborar que no se repita la persona mediante el dni, con
	// excepciones
	public boolean checkDni(String dni) throws DniAlreadyExistException 
	{
		if (usedDni.isEmpty())
		{
			return true;
		} 
		else 
		{
			for (String d : usedDni) 
			{
				throw new DniAlreadyExistException("El dni ya esta en uso.");
			}
		}
		return true;
	}
}