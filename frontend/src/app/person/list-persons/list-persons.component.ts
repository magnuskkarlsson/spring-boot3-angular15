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
