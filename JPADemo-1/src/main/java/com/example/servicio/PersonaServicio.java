package com.example.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.PersonaRepository;
import com.example.modelo.Persona;


@Service
@Transactional
public class PersonaServicio {

	private final PersonaRepository personaRepository;
	
	public PersonaServicio(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	public List<Persona> findAll() {
		List<Persona> collection = new ArrayList<>();
		for (Persona instance : personaRepository.findAll()) 
			collection.add(instance);
		
		return collection;
	}
}
