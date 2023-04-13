import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {OPERATING_CONTROL_POINTS_URL} from "../../core/constants";
import {OperatingControlPointResponse} from "./operating-control-point.model";

@Injectable({
  providedIn: 'root'
})
export class OperatingControlPointService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getPage(
    filter = '', sortOrder = 'asc',
    pageNumber = 0, pageSize = 10):  Observable<OperatingControlPointResponse> {

    return this.httpClient.get<OperatingControlPointResponse>(OPERATING_CONTROL_POINTS_URL, {
      params: new HttpParams()
        .set('sort', sortOrder)
        .set('page', pageNumber.toString())
        .set('size', pageSize.toString())
        .set('filter', filter)
    });
  }
}
