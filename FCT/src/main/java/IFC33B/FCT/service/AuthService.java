package IFC33B.FCT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
// TODO Check security implementation for JwtTokenUtils
import IFC33B.FCT.security.JwtTokenUtil;
import IFC33B.FCT.model.Usuari;
import IFC33B.FCT.dto.LoginRequest;
import IFC33B.FCT.dto.LoginResponse;
// TODO Check repository implementation for UserRepository
import IFC33B.FCT.repository.UserRepository;

@Service
public class AuthService {

    // Injecció d'independecis
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;

    // Servei de login
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userDetails);

        // TODO check userRepository implementation
        Usuari usuari = userRepository.findByUsername(request.getUsername())
                // TODO implement exception UsernameNotFoundException
                .orElseThrow(() -> new RuntimeException(request.getUsername()));

        return new LoginResponse(token, usuari.getUsername(), usuari.getNom(), usuari.getRols());
    }
}
