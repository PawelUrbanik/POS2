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


  updatePlatform(model: Platform) {

  }

  createPlatform(model: Platform) {

  }

  deletePlatform(id: number) {

  }
}
