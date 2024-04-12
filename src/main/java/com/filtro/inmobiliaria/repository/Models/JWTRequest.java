package com.filtro.inmobiliaria.repository.Models;

import lombok.Data;

@Data
public class JWTRequest {
    
    private String username;
    private String password;

}