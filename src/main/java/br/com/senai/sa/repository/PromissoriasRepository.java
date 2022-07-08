package br.com.senai.sa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senai.sa.entity.Promissoria;

public interface PromissoriasRepository extends JpaRepository<Promissoria, Integer>{
	
	@Query(value = 
			"SELECT p "
			+ "FROM Promissoria p "
			+ "WHERE p.codigo = :codigo ")
	Promissoria buscarPor(Integer codigo);
	
	@Query(value = 
			"SELECT p "
			+ "FROM Promissoria p "
			+ "JOIN FETCH p.cliente "
			+ "WHERE p.cliente.nomeCompleto LIKE :nomeCompleto ")
	List<Promissoria> listarPor(String nomeCompleto);

}
