import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Discriminant } from '../common/discriminant';

@Injectable({
  providedIn: 'root'
})
export class DiscriminantService {

  private baseUrl = 'http://localhost:8080/discriminants'

  constructor(private httpClient: HttpClient) { }

  getDiscriminant(): Observable<Discriminant[]> {
    return this.httpClient.get<Discriminant[]>(this.baseUrl);
  }
}
