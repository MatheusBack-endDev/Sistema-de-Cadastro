package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {
    private String name;
    private String email;
    private Integer idade;
    private Double altura;

    private static List<User> userList = new ArrayList<>();

    public User() {

    }

    public User(String name, String email, Integer idade, Double altura) {
        this.name = name;
        this.email = email;
        this.idade = idade;
        this.altura = altura;

        userList.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public static List<User> getUserList() {
        return userList;
    }

    public void buscaUsers(String name) {

        userList.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "User: " + name;
    }
}
