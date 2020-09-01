package com.upp.entidades;

public class UsuariosAsignados {
	private String asignadoUsr;
	private String email;
	public UsuariosAsignados() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuariosAsignados(String asignadoUsr, String email) {
		super();
		this.asignadoUsr = asignadoUsr;
		this.email = email;
	}
	public String getAsignadoUsr() {
		return asignadoUsr;
	}
	public void setAsignadoUsr(String asignadoUsr) {
		this.asignadoUsr = asignadoUsr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
