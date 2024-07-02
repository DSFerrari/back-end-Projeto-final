package com.agenda.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.agenda.dtos.AgendaRequest;
import com.agenda.agenda.dtos.AgendaResponse;
import com.agenda.agenda.entities.Agenda;
import com.agenda.agenda.mappers.AgendaMapper;
import com.agenda.agenda.repositories.AgendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    public List<AgendaResponse>getAgendas(){
        List<Agenda> agendas = agendaRepository.findAll();

        return agendas.stream()
                      .map(a -> AgendaMapper.toDTO(a))
                      .collect(Collectors.toList());
    }
    public AgendaResponse getAgendaById(int id) {
        Agenda agenda = agendaRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Aluno não cadastrado")
        );
        return AgendaMapper.toDTO(agenda);
    }
    public void deleteAgendaById(int id) {
        if (this.agendaRepository.existsById(id)) {
        this.agendaRepository.deleteById(id);
        }
        else {
        throw new EntityNotFoundException("pessoa não registrada");
        }
        }
        public AgendaResponse saveAgenda(AgendaRequest request) {
        Agenda agenda = AgendaMapper.toEntity(request);
        return 
       AgendaMapper.toDTO(this.agendaRepository.save(agenda));
        }
        public void updateAgenda(int id, AgendaRequest request) {
        try {
        Agenda aux = agendaRepository.getReferenceById(id);
        aux.setNome(request.nome());
        aux.setEmail(request.email());
        aux.setTelefone(request.telefone());
        aux.setCategoria(request.categoria());
        aux.setFavorito(request.favorito());
        aux.setGenero(request.genero());
        this.agendaRepository.save(aux);
        } catch (EntityNotFoundException e) {
        throw new EntityNotFoundException("pessoa não registrada");
        }
        }
    }