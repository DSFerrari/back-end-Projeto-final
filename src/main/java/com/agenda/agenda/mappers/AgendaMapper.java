package com.agenda.agenda.mappers;

import com.agenda.agenda.dtos.AgendaRequest;
import com.agenda.agenda.dtos.AgendaResponse;
import com.agenda.agenda.entities.Agenda;

public class AgendaMapper {
    public static Agenda toEntity(AgendaRequest request) {
       Agenda agenda = new Agenda();
        agenda.setNome(request.nome());
        agenda.setEmail(request.email());
        agenda.setTelefone(request.telefone());
        agenda.setCategoria(request.categoria());
        agenda.setFavorito(request.favorito());
        agenda.setGenero(request.genero());
        return agenda;
        }
        public static AgendaResponse toDTO(Agenda agenda) {
        return new AgendaResponse(agenda.getId(), 
       agenda.getNome(), agenda.getEmail(), agenda.getTelefone(),agenda.getCategoria(),agenda.isFavorito(),agenda.getGenero());
        }
        }