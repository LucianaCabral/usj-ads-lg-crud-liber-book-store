package br.edu.usj.ads.lgii.liber;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long>{

List<Livro>findAll(); 
List<Livro>findByAutor(String livro);
List<Livro>findByAutorContainingIgnoreCaseOrderByAutorAsc(String livro);
}
