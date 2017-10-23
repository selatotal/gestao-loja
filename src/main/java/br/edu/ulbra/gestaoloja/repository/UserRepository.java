package br.edu.ulbra.gestaoloja.repository;

import br.edu.ulbra.gestaoloja.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
