package com.codewithlipe.backendenviroment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
// Esta classe representa a entidade "User" que será mapeada para uma tabela no banco de dados
public class User {
    @Id
    @GeneratedValue

    // Identificador único de cada usuário abaixo com seus respectivos dados
    private Long id;
    private String username;
    private String name;
    private String email;

    // Getters e setters para acessar e modificar os campos da classe
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
