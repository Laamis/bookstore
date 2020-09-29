package hh.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//We define this as entity, so it can easily be ported to the h2 db
public class Category {

	//We autogenerate an id for the entity 
	//This means we can leave it out from the constructor
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//Constructor with parameters
	public Category(String name) {
		super();
		this.name = name;
	}
	//Constructor w/o parameters
	public Category() {
	}
	
	//Getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name; 
}
