package br.edu.usj.ads.lgii.liber;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
List<Cliente>findAll();
List<Livro>findByNome(String cliente);
List<Cliente>findByNomeContainingIgnoreCaseOrderByNomeAsc(String cliente); 
}
