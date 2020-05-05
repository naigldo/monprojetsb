package com.tactfactory.monprojetsb.monprojetsb.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	@OneToMany
	private List<Product> list;

    public User() {
    }

	public User(Long id, String firstname, String lastname, List<Product> list) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.list = list;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
}
