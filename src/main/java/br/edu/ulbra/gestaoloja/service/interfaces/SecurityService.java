package br.edu.ulbra.gestaoloja.service.interfaces;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
