package by.vasyabylba.taskmanagement.service;

import by.vasyabylba.taskmanagement.dto.JwtAuthenticationResponse;
import by.vasyabylba.taskmanagement.dto.SignInRequest;
import by.vasyabylba.taskmanagement.dto.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
}
