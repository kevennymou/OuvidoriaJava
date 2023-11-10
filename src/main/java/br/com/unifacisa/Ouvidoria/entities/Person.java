package br.com.unifacisa.Ouvidoria.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private boolean admin;
	
	public Person() {	
		
	}
	
	public Person(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		
	}
	
	public Integer getId() {
		return id;

	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getAdmin() {
		return admin;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public static boolean verificarAluno(String email2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static Object retornaPerson(String name2, String email2) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean verificarAluno1(String email2) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAdmin1() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
