package br.com.zupacademy.dani.mercadolivre.usuario;

import br.com.zupacademy.dani.mercadolivre.utils.UniqueValue;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioRequest {


    @NotBlank
    @Email
    @UniqueValue(targetClass = Usuario.class, fieldName = "login", message = "Esse email já está sendo utilizado por outro usuário.")
    private final String login;
    @NotBlank
    @Length(min = 6)
    private final String senha;


    public UsuarioRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toModel() {
        String senhaEncoded = new BCryptPasswordEncoder().encode(senha);
        return new Usuario(this.login, senhaEncoded);
    }
}
