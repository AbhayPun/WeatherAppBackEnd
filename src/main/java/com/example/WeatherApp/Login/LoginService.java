package com.example.WeatherApp.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping
    public List<Login> getLogin() {
        return loginRepository.findAll();
    }


    public void addNewLogin(Login login) {
            loginRepository.save(login);
    }

    public boolean userNameExists(String userName) {
        return loginRepository.findByUsername(userName).isPresent();
    }

    public boolean emailExists(String email) {
        return loginRepository.findByEmail(email).isPresent();
    }

    public boolean passwordExists(String password) {
        return loginRepository.findByPassword(password).isPresent();
    }
}
