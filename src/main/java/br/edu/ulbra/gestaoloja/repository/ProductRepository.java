package br.edu.ulbra.gestaoloja.repository;

import br.edu.ulbra.gestaoloja.model.Comment;
import br.edu.ulbra.gestaoloja.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
