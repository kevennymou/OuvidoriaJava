package br.com.unifacisa.Ouvidoria.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.unifacisa.Ouvidoria.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
