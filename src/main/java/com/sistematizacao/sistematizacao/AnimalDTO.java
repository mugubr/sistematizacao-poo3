package com.sistematizacao.sistematizacao;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AnimalDTO {

    @NotBlank(message = "O nome não pode estar vazio.")
    private String nome;

    @NotBlank(message = "O tipo do animal é obrigatório.")
    private String tipo;

    @Min(value = 0, message = "A idade deve ser um valor positivo.")
    private int idade;

    private String raca;

    @Pattern(regexp = "Disponível|Em processo de adoção|Adotado", message = "Status de adoção inválido")
    private String statusAdocao;

    private String descricao;
    private String imagemUrl;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getStatusAdocao() {
        return statusAdocao;
    }

    public void setStatusAdocao(String statusAdocao) {
        this.statusAdocao = statusAdocao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
