import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import { OPERATING_CONTROL_POINTS_URL} from "../../core/constants";
import {OperatingControlPointResponse, OperatingControlPointRowDto} from "./operating-control-point.model";

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

  create(point: OperatingControlPointRowDto) {
    this.httpClient.post(OPERATING_CONTROL_POINTS_URL , point).subscribe();
  }

  update(point: OperatingControlPointRowDto) {
    this.httpClient.put(OPERATING_CONTROL_POINTS_URL +"/"+point.id , point).subscribe();
  }
  delete(pointId: number) {
    this.httpClient.delete(OPERATING_CONTROL_POINTS_URL +"/"+pointId, {}).subscribe();
  }
}
