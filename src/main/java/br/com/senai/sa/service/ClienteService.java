package br.com.senai.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.sa.entity.Cliente;
import br.com.senai.sa.exception.RegistroNaoEncontradoException;
import br.com.senai.sa.repository.ClientesRepository;

@Validated
@Service
public class ClienteService {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	public Cliente inserir(Cliente cliente) {
		return clientesRepository.save(cliente);
	}
	
	public Cliente alterar(Cliente clienteSalvo) {
		return clientesRepository.save(clienteSalvo);
	}
	
	public void remover(Integer codigo) {
		this.clientesRepository.deleteById(codigo);
	}
	
	public Cliente buscarPor(Integer codigo) {
		Optional<Cliente> clienteEncontrado = clientesRepository.buscarPor(codigo);
		
		if(clienteEncontrado.isPresent()) {
			return clienteEncontrado.get();
		}
		
		throw new RegistroNaoEncontradoException("Cliente não encontrado");
	}
	
	public List<Cliente> buscarPor(String nomeCompleto) {
		return clientesRepository.listarPor("%"+nomeCompleto+"%");
	}
	

}
