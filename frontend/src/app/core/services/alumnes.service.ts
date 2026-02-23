import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Alumne } from '../models/alumne.model';

@Injectable({ providedIn: 'root' })
export class AlumnesService {
  private readonly API = 'http://localhost:8080/api/alumnes';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Alumne[]> {
    return this.http.get<Alumne[]>(this.API);
  }

  getById(id: number): Observable<Alumne> {
    return this.http.get<Alumne>(`${this.API}/${id}`);
  }

  create(alumne: Alumne): Observable<Alumne> {
    return this.http.post<Alumne>(this.API, alumne);
  }

  update(id: number, alumne: Alumne): Observable<Alumne> {
    return this.http.put<Alumne>(`${this.API}/${id}`, alumne);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }
}
