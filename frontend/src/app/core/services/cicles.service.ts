import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cicle } from '../models/cicle.model';

@Injectable({ providedIn: 'root' })
export class CiclesService {
  private readonly API = 'http://localhost:8080/api/cicles';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Cicle[]> {
    return this.http.get<Cicle[]>(this.API);
  }

  getById(id: number): Observable<Cicle> {
    return this.http.get<Cicle>(`${this.API}/${id}`);
  }

  create(cicle: Cicle): Observable<Cicle> {
    return this.http.post<Cicle>(this.API, cicle);
  }

  update(id: number, cicle: Cicle): Observable<Cicle> {
    return this.http.put<Cicle>(`${this.API}/${id}`, cicle);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }
}
