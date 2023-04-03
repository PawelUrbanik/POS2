import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Discriminant} from "../discriminant/discriminant";
import {DISCRIMINANT_URL, OPERATING_CONTROL_POINTS_URL} from "../../core/constants";
import {OperatingControlPointRowDto} from "./operating-control-point.model";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class OperatingControlPointService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getPoints(): Observable<OperatingControlPointRowDto[]> {
    return this.httpClient.get<OperatingControlPointRowDto[]>(OPERATING_CONTROL_POINTS_URL);
  }

  getPage(page: number, size: number): Observable<{ content: OperatingControlPointRowDto[], count: number }>{
    return this.httpClient.get<{ content: OperatingControlPointRowDto[], count: number }>(OPERATING_CONTROL_POINTS_URL,
      {params: {page: page.toString(), size: size.toString()}})
  }
}
