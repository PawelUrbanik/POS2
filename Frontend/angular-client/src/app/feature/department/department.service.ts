import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DepartmentRowDto} from "./department.model";
import {DEPARTMENTS_URL} from "../../core/constants";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(private http: HttpClient) { }

  getDepartments(): Observable<DepartmentRowDto[]> {
    return this.http.get<DepartmentRowDto[]>(DEPARTMENTS_URL);
  }
}


