package com.demo.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.demo.jpa.model.Persona;

public interface PersonaRepository extends PagingAndSortingRepository<Persona, Integer> {
	List<Persona> findByEstado(char estado);
	List<Persona> findByNombresIgnoreCaseContaining(String nombre);
	
	@Query(nativeQuery = true, value = "select * from persona where nombres like (concat('%',:cadena,'%')) or apellidos like (concat('%',:cadena,'%')) order by id_persona asc limit :size offset :page")
	List<Persona> findByPageUsingNativeQuery(@Param("cadena") String cadena, @Param("page") int page, @Param("size") int size);
}
