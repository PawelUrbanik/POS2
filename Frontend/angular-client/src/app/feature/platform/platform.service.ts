import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Platform} from "./platform.model";
import {PLATFORMS_URL} from "../../core/constants";

@Injectable({
  providedIn: 'root'
})
export class PlatformService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getOne(id: number): Observable<Platform> {
    return this.httpClient.get<Platform>(PLATFORMS_URL+"/get/"+id);
  }


  updatePlatform(platform: Platform) {
    return this.httpClient.put<Platform>(PLATFORMS_URL, platform)
  }

  createPlatform(platform: Platform, operatingControlPointId: number) {
    return this.httpClient.post(PLATFORMS_URL+"/add/"+operatingControlPointId, platform)
  }

  deletePlatform(id: any) {
    return this.httpClient.delete(PLATFORMS_URL+'/'+ id, {})
  }
}
