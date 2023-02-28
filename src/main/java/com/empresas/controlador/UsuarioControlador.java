package com.empresas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresas.excepciones.ResourceNotFoundException;
import com.empresas.modelo.Usuario;
import com.empresas.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	//Método para listar las empresas
	@GetMapping("/usuarios")
	public List<Usuario> listarTodasLasEmpresas(){
		return repositorio.findAll();
	}
	
	//Método para guardar usuario
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	//Método para buscar un usuario por su ID
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
		Usuario usuario = repositorio.findById(id)
						  .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con ID: + id")); //Si no existe se manda este mensaje 
		return ResponseEntity.ok(usuario);
	}
	
	//Método para actualizar usuario por su ID
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario detallesUsuario){
		Usuario usuario = repositorio.findById(id)
				  .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con ID: + id")); //Si no existe se manda este mensaje 
		usuario.setCodigo(detallesUsuario.getCodigo());
		usuario.setNombre(detallesUsuario.getNombre());
		usuario.setEmail(detallesUsuario.getEmail());
		usuario.setEmpresa(detallesUsuario.getEmpresa());
		
		Usuario usuarioActualizado = repositorio.save(usuario);
		
		return ResponseEntity.ok(usuarioActualizado);
	}
}
