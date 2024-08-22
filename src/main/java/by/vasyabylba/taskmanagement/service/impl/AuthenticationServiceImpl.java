package by.vasyabylba.taskmanagement.service.impl;

import by.vasyabylba.taskmanagement.dto.JwtAuthenticationResponse;
import by.vasyabylba.taskmanagement.dto.SignInRequest;
import by.vasyabylba.taskmanagement.dto.SignUpRequest;
import by.vasyabylba.taskmanagement.error.UserNotValidException;
import by.vasyabylba.taskmanagement.model.User;
import by.vasyabylba.taskmanagement.repository.UserRepository;
import by.vasyabylba.taskmanagement.security.JwtService;
import by.vasyabylba.taskmanagement.security.UserDetailsServiceImpl;
import by.vasyabylba.taskmanagement.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest signUpRequest) {
        String email = signUpRequest.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new UserNotValidException("User with email '%s' already exists".formatted(email));
        }
        User user = User.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();
        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(signUpRequest.getEmail());
        var jwt = jwtService.generateToken(userDetails);
        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(),
                signInRequest.getPassword()
        ));

        UserDetails userDetails = userDetailsService.loadUserByUsername(signInRequest.getEmail());
        String jwt = jwtService.generateToken(userDetails);
        return new JwtAuthenticationResponse(jwt);
    }
}
