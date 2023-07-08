# Read Me First
The following was discovered as part of building this project:

* The original package name 'se.magnuskkarlsson.spring-boot-angular' is invalid and this project uses 'se.magnuskkarlsson.springbootangular' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

# Building Spring Boot Jar with Angular

https://40dev.com/2022/09/spring-boot-angular-maven-config/

# Run
Backend

	$ mvn spring-boot:run

	http://localhost:8080/api/persons

# Frontend 

	$ ng version
	...
	Angular CLI: 15.2.6
	Node: 18.16.0
	Package Manager: npm 9.5.1
	OS: linux x64

https://40dev.com/2022/09/spring-boot-angular-maven-config/
https://github.com/40devweb/mvn-ng-sb

	$ ng new frontend
	? Would you like to add Angular routing? Yes
	? Which stylesheet format would you like to use? CSS
	...

	$ ng serve

	http://localhost:4200/

src/environments/environment.ts

	export const environment = {
	    production: false,
	    api: 'http://localhost:8080/api/'
	};

	$ ng generate service person/person

src/app/person/person.service.ts

	import { Injectable } from '@angular/core';
	import { HttpClient } from '@angular/common/http';
	import { Observable } from 'rxjs';
	import { environment } from 'src/environments/environment';
	
	export interface Person {
	  id: number | null, // null for new objects
	  firstName: string,
	  lastName: string
	}
	
	@Injectable({
	  providedIn: 'root'
	})
	export class PersonService {
	
	  constructor(private http: HttpClient) { }
	
	  public getAll(): Observable<Person[]> {
	    return this.http.get<Person[]>(environment.api + 'persons')
	  }
	}

src/app/app.module.ts

	...
	import { HttpClientModule } from '@angular/common/http';
	...
	@NgModule({
	...
	  imports: [
	...
	    HttpClientModule
	  ],
	...

	$ ng generate component person/list-persons

src/app/app.component.html

	<app-list-persons></app-list-persons>

src/app/person/list-persons/list-persons.component.ts

	import { Component, OnInit } from '@angular/core';
	import { Person, PersonService } from '../person.service';
	
	@Component({
	  selector: 'app-list-persons',
	  templateUrl: './list-persons.component.html',
	  styleUrls: ['./list-persons.component.css']
	})
	export class ListPersonsComponent implements OnInit {
	  persons?: Person[];
	
	  constructor(private personService: PersonService) { }
	
	  ngOnInit(): void {
	    this.personService.getAll().subscribe(persons => {
	      this.persons = persons;
	    });
	  }
	}

src/app/person/list-persons/list-persons.component.html

	<table>
	    <tr>
	        <th>Id</th>
	        <th>First Name</th>
	        <th>Last Name</th>
	    </tr>
	    <tr *ngFor="let person of persons">
	        <td>{{person.id}}</td>
	        <td>{{person.firstName}}</td>
	        <td>{{person.lastName}}</td>
	    </tr>
	</table>

