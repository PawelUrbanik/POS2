import {OperatingControlPointRowDto} from "../operating-control-point.model";
import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {BehaviorSubject, Observable, of} from "rxjs";
import {OperatingControlPointService} from "../operating-control-point.service";
import {catchError, finalize, map} from "rxjs/operators";

export class OperatingControlPointDatasource implements DataSource<OperatingControlPointRowDto> {

  private pointsSubject = new BehaviorSubject<OperatingControlPointRowDto[]>([]);
  private loadingSubject = new BehaviorSubject<boolean>(false);
  public totalElements = new BehaviorSubject<number>(0);
  public loading$ = this.loadingSubject.asObservable();

  constructor(private operatingControlPointService: OperatingControlPointService) {}

  connect(collectionViewer: CollectionViewer): Observable<OperatingControlPointRowDto[]> {
    return this.pointsSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.pointsSubject.complete();
    this.loadingSubject.complete();
  }

  loadPoints(filter = '',
              sortDirection = 'asc', pageIndex = 0, pageSize = 3) {

    this.loadingSubject.next(true);

    this.operatingControlPointService.getPage(filter, sortDirection,
      pageIndex, pageSize).pipe(
      catchError(() => of([])),
      finalize(() => this.loadingSubject.next(false))
    )
      .pipe(
        map(response => {
          if (response instanceof Array) {
            return response;
          } else {
            this.totalElements.next(response.totalElements);
            return response.content;
          }
        })
      )
      .subscribe(points => {
        this.pointsSubject.next(points);
      });
  }
}
