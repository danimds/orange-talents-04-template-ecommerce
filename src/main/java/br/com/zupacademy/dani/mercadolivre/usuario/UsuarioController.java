package br.com.zupacademy.dani.mercadolivre.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid UsuarioRequest request) {
        Optional<Usuario> emailDuplicado = usuarioRepository.findByLogin(request.getLogin());
        if (emailDuplicado.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Usuario novoUsuario = request.toModel();
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }


}
