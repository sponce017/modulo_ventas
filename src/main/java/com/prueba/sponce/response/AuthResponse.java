package com.prueba.sponce.response;


import com.prueba.sponce.dto.Body;
import lombok.Data;

@Data
public class AuthResponse {

    private String status;
    private Body body;
    private String error;
    private String message;

}
