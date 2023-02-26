package com.empresas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresas.modelo.Empresa;
import com.empresas.repositorio.EmpresaRepositorio;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpresaControlador {
	
	@Autowired
	private EmpresaRepositorio repositorio;
	
	@GetMapping("")
	public List<Empresa> listarTodasLasEmpresas(){
		return repositorio.findAll();
	}
	
}
