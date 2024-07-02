package com.agenda.agenda.dtos;

public record AgendaResponse(int id,String nome, String email, String telefone, String categoria, boolean favorito, String genero) {
}
