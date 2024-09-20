package com.example.WeatherApp.Login;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController
{

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/username-exists")
    public boolean checkUsernameExists(@RequestParam String username) {
        return loginService.userNameExists(username);
    }

    @GetMapping("/email-exists")
    public boolean checkEmailExists(@RequestParam String email) {
        return loginService.emailExists(email);
    }

    @GetMapping("/password-exists")
    public boolean checkPasswordExists(@RequestParam String password) {
        return loginService.passwordExists(password);
    }

    @GetMapping()
    public List<Login> getLogin() {
        return loginService.getLogin();
    }

    @PostMapping()
    public void registerNewLogin(@RequestBody Login login) {

        if(!loginService.emailExists(login.getEmail()) && !loginService.userNameExists(login.getUsername())) {
            System.out.println("account added");

            loginService.addNewLogin(login);
        }
    }
    

}
