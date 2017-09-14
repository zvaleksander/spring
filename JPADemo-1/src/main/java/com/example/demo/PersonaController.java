package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Persona;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/controlador")
public class PersonaController {
	
	/**
	 * home/get
	 * home/get/{id}
	 * home/add
	 * home/update/{id} 
	 * home/delete/{id}
	 */
	
	public PersonaController() {
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get() {
		return "[personas]";
	}
	
	
}
