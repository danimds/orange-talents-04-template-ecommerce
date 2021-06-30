package br.com.zupacademy.dani.mercadolivre.categoria;

import br.com.zupacademy.dani.mercadolivre.utils.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

public class CategoriaRequest {
    @NotBlank
    @UniqueValue( targetClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada.")
    private String nome;
    private Long idCategoriaMae;

    public CategoriaRequest(String nome, Long idCategoriaMae) {
        this.nome = nome;
        this.idCategoriaMae = idCategoriaMae;
    }

    public Categoria toModel (CategoriaRepository categoriaRepository) {
        Categoria categoria = new Categoria(nome);
        if (idCategoriaMae != null) {
            Optional<Categoria> categoriaMae = categoriaRepository.findById(idCategoriaMae);
            if (categoriaMae.isPresent())
                categoria.setCategoriaMae(categoriaMae.get());
        }
        return categoria;
    }

}
