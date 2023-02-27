package com.empresas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresas.excepciones.ResourceNotFoundException;
import com.empresas.modelo.Empresa;
import com.empresas.repositorio.EmpresaRepositorio;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpresaControlador {
	
	@Autowired
	private EmpresaRepositorio repositorio;
	
	
	//Método para listar las empresas
	@GetMapping("/empresas")
	public List<Empresa> listarTodasLasEmpresas(){
		return repositorio.findAll();
	}
	
	//Método para guardar empresas
	@PostMapping("/empresas")
	public Empresa guardarEmpresa(@RequestBody Empresa empresa) {
		return repositorio.save(empresa);
	}
}
