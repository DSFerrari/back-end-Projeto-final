package com.agenda.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.agenda.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda,Integer> {
}
