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
