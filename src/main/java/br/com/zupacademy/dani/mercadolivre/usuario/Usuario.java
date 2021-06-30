package br.com.zupacademy.dani.mercadolivre.usuario;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Email
    @Column(unique = true)
    private  String login;
    @NotBlank
    @Length(min = 6)
    private String senha;
    private  LocalDateTime dataCriacao;

    @Deprecated
    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        dataCriacao = LocalDateTime.now();
    }
}
