package se.magnuskkarlsson.springboot3angular15.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private List<Person> persons = new ArrayList<>();
	// https://magnus-k-karlsson.blogspot.com/2019/04/generating-test-data-javafaker.html
	private final Faker faker = new Faker(new Locale("sv-SE")); // default Locale("en", "")

	@PostConstruct
	public void init() {
		for (long i = 1; i < 11; ++i) {
			Person person = new Person() //
					.setId(i) //
					.setFirstName(faker.name().firstName()) //
					.setLastName(faker.name().lastName());
			persons.add(person);
		}
	}

	// ----------------------- Logic Methods -----------------------

	// ----------------------- Helper Methods -----------------------

	// ----------------------- Get and Set Methods -----------------------

	@GetMapping
	public List<Person> getAll() {
		return persons;
	}
}
