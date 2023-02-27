package com.empresas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empresas.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "https://localhost:4200")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	

}
