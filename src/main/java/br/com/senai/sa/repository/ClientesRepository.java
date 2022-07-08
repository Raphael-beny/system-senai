package br.com.senai.sa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senai.sa.entity.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer>{
	
//	@Query(value = 
//			"SELECT u "
//			+ "FROM Usuario u "
//			+ "WHERE u.login = :login "
//			+ "AND u.senha = :senha ")
//	Cliente buscarPor(String login, String senha);
	
	@Query(value = 
			"SELECT c "
			+ "FROM Cliente c "
			+ "WHERE c.codigo = :codigo ")
	Cliente buscarPor(Integer codigo);
	
	@Query(value = 
			"SELECT c "
			+ "FROM Cliente c "
			+ "WHERE c.nomeCompleto LIKE :nomeCompleto ")
	List<Cliente> listarPor(String nomeCompleto);

}
