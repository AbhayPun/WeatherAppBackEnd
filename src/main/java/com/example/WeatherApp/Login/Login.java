package com.example.WeatherApp.Login;
import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @SequenceGenerator(
            name = "login_sequence",
            sequenceName = "login_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "login_sequence"
    )
    private int id;

    private String username, password,email ;
    private int age;

    public Login (String username, String password, String email, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public Login() {

    }



    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }



    public int getAge() {
        return age;
    }


}
