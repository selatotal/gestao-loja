package br.edu.ulbra.gestaoloja.service.interfaces;

import br.edu.ulbra.gestaoloja.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
