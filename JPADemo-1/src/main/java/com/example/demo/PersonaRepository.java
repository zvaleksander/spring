package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> { }
