package IFC33B.FCT.dto;

import lombok.Data;

@Data
public class LoginResponse {
    // Atributs
    private String token;
    private String username;
    private String nom;
    private String[] rols;

    // Construcor
    public LoginResponse(String token, String username, String nom, String[] rols) {
        this.setToken(token);
        this.setUsername(username);
        this.setNom(nom);
        this.setRols(rols);
    }
}
