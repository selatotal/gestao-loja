package br.edu.ulbra.gestaoloja.service.interfaces;

import br.edu.ulbra.gestaoloja.model.User;

public interface SecurityService {

    String findLoggedInUsername();

    User findLoggedInUser();

    void autologin(String username, String password);
}
