package br.com.unifacisa.Ouvidoria.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.Ouvidoria.entities.Aluno;
import br.com.unifacisa.Ouvidoria.entities.Manifest;
import br.com.unifacisa.Ouvidoria.entities.Ocorrencia;
import br.com.unifacisa.Ouvidoria.entities.Person;
import br.com.unifacisa.Ouvidoria.repositories.PersonRepository;
import br.com.unifacisa.Ouvidoria.repositories.ManifestRepositiry;

@Service
public class PersonService {

	
	private static Person[] lista;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	ManifestRepositiry manifestRepository;
	
	public String addPerson(Integer id, String name, String email) {
		try {
			Person p = new Person(id , name, email);
			personRepository.save(p);
			return "Pessoa Salva";
	} catch (Exception e) {
		System.out.println("Algo deu errado");
	}
	 return "Erro";
}
	public boolean listarTodos() {
		for (Person p : personRepository.findAll()) {
			if (p != null) {
				System.out.println(p.toString());
			} else {
				System.out.println("Nao existem pessoas Cadastradas");
	        }	
		}
		return false;
	}

	public void deletar() {
		ArrayList<Person> lista = (ArrayList<Person>) personRepository.findAll();
		for (Person p : lista) {
			personRepository.delete(p);
		}
		
	}
	public static boolean verificarAluno(String email2) {
		for (Person p : lista) {
			if (p.getEmail() == email2) {
				return true;
			}
		}
		return false;
	}
	public void addPerson(Aluno usuario) {
		// TODO Auto-generated method stub
		
	}
	
	public Person retornarPerson(String name, String email) {
		ArrayList<Person> lista = (ArrayList<Person>) personRepository.findAll();
		for (Person p : lista) {
			if (name.equals(p.getName()) && email.equals(p.getEmail())) {
				return p;
				
			}
		}
		return null;
		
		
	}
	
	public static boolean verificarAdmin(String name, String email) {
		for (Person person : lista) {
			if (name.equals(person.getName()) && person.getAdmin() == true && email.equals(person.getEmail())) {
				return true;
			}
		}
		return false;
		
	}
	
	public String addManifest(Integer id, String tipo) {
		try {
			Manifest m = new Manifest(id , tipo);
			manifestRepository.save(m);
			return "Ocorrencia Salva";
	} catch (Exception e) {
		System.out.println("Algo deu errado");
	}
	 return "Erro";
	}
	
	public boolean listarManifestacao() {
		for (Manifest m : manifestRepository.findAll()) {
			if (m != null) {
				System.out.println(m.toString());
			} else {
				System.out.println("Nao existem ocorrencia Cadastrada");
	        }	
		}
		return false;
	}
	
	public void deletePerson(Integer id) {
		personRepository.deleteById(id);
		
	}
	
	public void deleteManifest(String tipo) {
		manifestRepository.deleteById(null);
	}
	
	public void deleteAll() {
		manifestRepository.deleteAll();
	}
	public void addManifest(Ocorrencia ocorrencia) {
		// TODO Auto-generated method stub
		
	}
	
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}