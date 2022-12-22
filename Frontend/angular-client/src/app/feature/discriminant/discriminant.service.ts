import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Discriminant} from './discriminant';
import {DISCRIMINANT_URL} from "../../core/constants";

@Injectable({
  providedIn: 'root'
})
export class DiscriminantService {

  constructor(private httpClient: HttpClient) {
  }

  getDiscriminant(): Observable<Discriminant[]> {
    return this.httpClient.get<Discriminant[]>(DISCRIMINANT_URL);
  }

  updateDiscriminant(discriminant: Discriminant) {
   this.httpClient.put(DISCRIMINANT_URL + '/' + discriminant.id, discriminant).subscribe();
  }

  createDiscriminant(discriminant: Discriminant) {
    this.httpClient.post(DISCRIMINANT_URL , discriminant).subscribe();
  }
}
