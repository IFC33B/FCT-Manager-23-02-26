import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tutor } from '../models/tutor.model';

@Injectable({ providedIn: 'root' })
export class TutorsService {
  private readonly API = 'http://localhost:8080/api/tutors';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Tutor[]> {
    return this.http.get<Tutor[]>(this.API);
  }

  getById(id: number): Observable<Tutor> {
    return this.http.get<Tutor>(`${this.API}/${id}`);
  }

  create(tutor: Tutor): Observable<Tutor> {
    return this.http.post<Tutor>(this.API, tutor);
  }

  update(id: number, tutor: Tutor): Observable<Tutor> {
    return this.http.put<Tutor>(`${this.API}/${id}`, tutor);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }
}
