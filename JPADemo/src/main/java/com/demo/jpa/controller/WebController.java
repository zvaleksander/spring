package com.demo.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpa.model.Persona;
import com.demo.jpa.repository.PersonaRepository;

@RestController
public class WebController {

	@Autowired
	private PersonaRepository repository;
	
	@RequestMapping(value = "/personas/pageable", method = RequestMethod.GET)
	public List<Persona> findAll(Pageable pageable) {
		List<Persona> collection = new ArrayList<Persona>();
		for (Persona instance : repository.findAll(pageable)) {
			collection.add(instance);
		}	
		
		return collection;
	}
	
	@RequestMapping(value = "/personas/native-query", method = RequestMethod.GET)
	public List<Persona> findAll(@RequestParam(name = "nombre") String filter, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
		List<Persona> collection = new ArrayList<Persona>();
		for (Persona instance : repository.findByPageUsingNativeQuery(filter, page, size)) {
			collection.add(instance);
		}	
		
		return collection;
	}
	
	@RequestMapping(value = "/personas/page-request", method = RequestMethod.GET)
	public List<Persona> findAllByPage(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
		List<Persona> collection = new ArrayList<Persona>();
		
		PageRequest request = new PageRequest(page, size, Sort.Direction.ASC, "id");
		
		for (Persona instance : repository.findAll(request)) {
			collection.add(instance);
		}	
		
		return collection;
	}
	
	@RequestMapping(value = "/personas/count", method = RequestMethod.GET)
	public Long count() {
		return repository.count();
	}
	
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.GET)
	public Persona findById(@PathVariable int id) {
		Persona instance = repository.findOne(id);
		
		return instance;
	}
	
	@RequestMapping(value = "/personas/estado/{estado}", method = RequestMethod.GET)
	public List<Persona> findAllByEstado(@PathVariable char estado) {
		List<Persona> collection = new ArrayList<Persona>();
		for (Persona instance : repository.findByEstado(estado)) {
			collection.add(instance);
		}
		
		return collection;
	}
	
	@RequestMapping(value = "/personas/nombre/{nombre}", method = RequestMethod.GET)
	public List<Persona> findAllByEstado(@PathVariable String nombre) {
		List<Persona> collection = new ArrayList<Persona>();
		for (Persona instance : repository.findByNombresIgnoreCaseContaining(nombre)){
			collection.add(instance);
		}
		
		return collection;
	}
	
	@RequestMapping(value = "/personas", method = RequestMethod.POST)
	public @ResponseBody HttpStatus save(@RequestBody Persona instance) {
		try {
			repository.save(instance);
			
			return HttpStatus.OK;
		}
		catch (Exception e) {
			return HttpStatus.CONFLICT;
		}
	}
	
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE)
	public @ResponseBody HttpStatus delete(@PathVariable int id) {
		try {
			repository.delete(id);
			
			return HttpStatus.OK;
		}
		catch (Exception e) {
			return HttpStatus.CONFLICT;
		}
	}
}
