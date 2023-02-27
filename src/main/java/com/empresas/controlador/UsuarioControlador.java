package com.empresas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresas.modelo.Usuario;
import com.empresas.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "https://localhost:4200")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	

	//Método para listar las empresas
	@GetMapping("/usuarios")
	public List<Usuario> listarTodasLasEmpresas(){
		return repositorio.findAll();
	}
}
