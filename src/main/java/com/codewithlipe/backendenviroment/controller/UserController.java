package com.codewithlipe.backendenviroment.controller;

import com.codewithlipe.backendenviroment.exception.UserNotFoundException;
import com.codewithlipe.backendenviroment.model.User;
import com.codewithlipe.backendenviroment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Enviando os dados da database para o front-end
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // Criação de usuário na tabela
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    // Leitura de usuários na tabela
    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Leitura de um usuário específico na tabela pelo ID
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    // Atualização de um usuário na tabela pelo ID
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFoundException(id));
    }

    // Exclusão de um usuário na tabela pelo ID
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with " + id + " has been deleted successfully.";
    }
}
