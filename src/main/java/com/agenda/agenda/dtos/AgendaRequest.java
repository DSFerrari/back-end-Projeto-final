package com.agenda.agenda.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgendaRequest(
    @NotNull(message = "Nome não pode ser nulo")
    String nome,
    @NotBlank(message = "Email não pode ser nulo")
    String email,
    @NotBlank(message = "Telefone não pode ser nulo")
    String telefone,
    @NotBlank(message = "Categoria não pode ser nula")
    String categoria,
    boolean favorito,
    @NotBlank(message = "Genero não pode ser nulo")
    String genero
) {
    
}
