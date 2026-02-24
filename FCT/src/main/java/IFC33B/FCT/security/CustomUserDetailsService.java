package IFC33B.FCT.security;

import IFC33B.FCT.security.model.Usuari;
import IFC33B.FCT.security.repository.UsuariRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

// CustomUserDetailsService is a service that implements UserDetailsService to load user details from the database for authentication purposes..
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    // base de datos de los usuarios
    private final UsuariRepository useriRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuari usuari = useriRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuari not trobat " + username));

        // devuelve un objeto UserDetails con el nombre de usuario, contraseña
        // y los roles del usuario para que Spring Security pueda realizar la autenticación y autorización.
        return org.springframework.security.core.userdetails.User
                .withUsername(usuari.getUsername())
                .password(usuari.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLS_" + usuari.getRols())))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .build();
    }
}
