package com.demo.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="persona")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int id;
	private String nombres;
	private String apellidos;
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	private String telefono;
	private String correo;
	private char estado;
	
	public Persona() {}
	
	public Persona(String nombres, String apellidos, Date fechaNacimiento, String telefono, String correo, char estado) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.correo = correo;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public char getEstado() {
		return estado;
	}
	
	public void setEstado(char estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", telefono=" + telefono + ", correo=" + correo + ", estado=" + estado + "]";
	}
}
