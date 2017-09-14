package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Persona;
import com.example.servicio.PersonaServicio;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {

	@Autowired
	private PersonaServicio personaServicio;

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String findAll() {
		return "personaServicio.findAll()";
	}
}
