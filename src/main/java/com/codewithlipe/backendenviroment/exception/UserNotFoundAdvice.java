package com.codewithlipe.backendenviroment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
// Classe responsável por tratar exceções do tipo UserNotFoundException em toda a aplicação
public class UserNotFoundAdvice {

    // Método para tratar a exceção UserNotFoundException e retornar uma resposta HTTP 404 Not Found
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException exception){
        // Criação de um mapa para armazenar as informações de erro
        Map<String,String> errorMap=new HashMap<>();
        // Adiciona a mensagem de erro ao mapa
        errorMap.put("Error message: ", exception.getMessage());
        // Retorna o mapa com as informações de erro
        return errorMap;
    }
}
