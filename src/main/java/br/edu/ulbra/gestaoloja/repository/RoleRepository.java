package br.edu.ulbra.gestaoloja.repository;

import br.edu.ulbra.gestaoloja.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Set<Role> findAllByName(String name);
}
