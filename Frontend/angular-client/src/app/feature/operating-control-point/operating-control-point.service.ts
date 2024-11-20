import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {OPERATING_CONTROL_POINTS_URL} from "../../core/constants";
import {PLATFORMS_URL} from "../../core/constants";
import {
  OperatingControlPointFormDto,
  OperatingControlPointResponse,
  OperatingControlPointSearchCriteria, PlatformOptionDto, PlatformRowDto
} from "./operating-control-point.model";

@Injectable({
  providedIn: 'root'
})
export class OperatingControlPointService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getPage(
    filter?: OperatingControlPointSearchCriteria, sortOrder = 'asc',
    pageNumber = 0, pageSize = 10):  Observable<OperatingControlPointResponse> {

    let discriminantId = filter?.discriminantId == null ? '' : filter.discriminantId;
    let departmentId = filter?.departmentId == null ? '' : filter.departmentId;
    let pointName: string = filter?.pointName == null ? '' : filter.pointName;
    return this.httpClient.get<OperatingControlPointResponse>(OPERATING_CONTROL_POINTS_URL, {
      params: new HttpParams()
        .set('sort', sortOrder)
        .set('page', pageNumber.toString())
        .set('size', pageSize.toString())
        .set('name', pointName)
        .set('discriminantId', discriminantId)
        .set('departmentId', departmentId)
    });
  }

  getOne(id: number): Observable<OperatingControlPointFormDto> {
    return this.httpClient.get<OperatingControlPointFormDto>(OPERATING_CONTROL_POINTS_URL+"/"+id);
  }

  create(point: OperatingControlPointFormDto) {
    this.httpClient.post(OPERATING_CONTROL_POINTS_URL , point).subscribe();
  }

  update(point: OperatingControlPointFormDto) {
    this.httpClient.put(OPERATING_CONTROL_POINTS_URL +"/"+point.id , point).subscribe();
  }
  delete(pointId: number) {
    this.httpClient.delete(OPERATING_CONTROL_POINTS_URL +"/"+pointId, {}).subscribe();
  }

  getPlatformsList(pointId: number): Observable<PlatformRowDto[]> {
    return this.httpClient.get<PlatformRowDto[]>(PLATFORMS_URL + "/getList/"+ pointId, {});
  }
}
