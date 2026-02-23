import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Conveni } from '../models/conveni.model';

@Injectable({ providedIn: 'root' })
export class ConvenisService {
  private readonly API = 'http://localhost:8080/api/convenis';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Conveni[]> {
    return this.http.get<Conveni[]>(this.API);
  }

  getById(id: number): Observable<Conveni> {
    return this.http.get<Conveni>(`${this.API}/${id}`);
  }

  create(conveni: Conveni): Observable<Conveni> {
    return this.http.post<Conveni>(this.API, conveni);
  }

  update(id: number, conveni: Conveni): Observable<Conveni> {
    return this.http.put<Conveni>(`${this.API}/${id}`, conveni);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }
}
