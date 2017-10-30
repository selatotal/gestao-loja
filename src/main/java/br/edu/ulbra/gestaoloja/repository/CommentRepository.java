package br.edu.ulbra.gestaoloja.repository;

import br.edu.ulbra.gestaoloja.model.Comment;
import br.edu.ulbra.gestaoloja.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
