package com.empresas.modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codigo", length=5, nullable=false, unique=true)
	private int codigo;

	@Column(name = "nombre", length=50, nullable=false)
	private String nombre;

	@Column(name = "email", length=50, nullable=false, unique=true)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable=false)
	private Empresa empresa;
	
	public Usuario() {
		
	}

	public Usuario(Long id, int codigo, String nombre, String email, Empresa empresa) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Empresa getEempresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
