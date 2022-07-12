package br.com.senai.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.sa.entity.Promissoria;
import br.com.senai.sa.exception.RegistroNaoEncontradoException;
import br.com.senai.sa.repository.PromissoriasRepository;

@Validated
@Service
public class PromissoriaService {
	
	@Autowired
	private PromissoriasRepository promissoriasRepository;
	
	public Promissoria inserir(Promissoria promissoria) {
		return promissoriasRepository.save(promissoria);
	}
	
	public Promissoria alterar(Promissoria promissoriaSalvo) {
		return promissoriasRepository.save(promissoriaSalvo);
	}
	
	public void remover(Integer codigo) {
		this.promissoriasRepository.deleteById(codigo);
	}
	
	public Promissoria buscarPor(Integer codigo) {
		Optional<Promissoria> promissoriaEncontrada = promissoriasRepository.buscarPor(codigo);
		
		if(promissoriaEncontrada.isPresent()) {
			return promissoriaEncontrada.get();
		}
		
		throw new RegistroNaoEncontradoException("Promissória não encontrada");
	}
	
	public List<Promissoria> buscarPor(String nomeCompleto) {
		return promissoriasRepository.listarPor("%"+nomeCompleto+"%");
	}
	

}
