package com.empresas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresas.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
