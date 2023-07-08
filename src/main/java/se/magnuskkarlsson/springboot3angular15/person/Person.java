package se.magnuskkarlsson.springboot3angular15.person;

public class Person {
	private Long id;
	private String firstName;
	private String lastName;

	// ----------------------- Logic Methods -----------------------

	// ----------------------- Helper Methods -----------------------

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	// ----------------------- Get and Set Methods -----------------------

	public Long getId() {
		return id;
	}

	public Person setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Person setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
}
