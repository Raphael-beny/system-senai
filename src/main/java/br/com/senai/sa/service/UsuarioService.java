package br.com.senai.sa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.sa.entity.Usuario;
import br.com.senai.sa.exception.RegistroNaoEncontradoException;
import br.com.senai.sa.repository.UsuariosRepository;

@Validated
@Service
public class UsuarioService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public Usuario inserir(Usuario usuario) {
		return usuariosRepository.save(usuario);
	}
	
	public Usuario alterar(Usuario usuarioSalvo) {
		return usuariosRepository.save(usuarioSalvo);
	}
	
	public void remover(Integer codigo) {
		this.usuariosRepository.deleteById(codigo);
	}
	
//	public Optional<Usuario> buscarPor(String login, String senha) {
//		Optional<Usuario> usuarioEncontrado = usuariosRepository.buscarParaLoginPor(login, senha);
//		return usuarioEncontrado.isPresent() ? usuarioEncontrado.get() : 
//			throw new RegistroNaoEncontradoException("");
//	}

}
