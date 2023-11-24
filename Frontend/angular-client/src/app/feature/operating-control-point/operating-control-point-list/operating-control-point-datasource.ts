import {OperatingControlPointRowDto, OperatingControlPointSearchCriteria} from "../operating-control-point.model";
import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {BehaviorSubject, Observable, of} from "rxjs";
import {OperatingControlPointService} from "../operating-control-point.service";
import {catchError, finalize, map} from "rxjs/operators";

export class OperatingControlPointDatasource implements DataSource<OperatingControlPointRowDto> {

  private pointsSubject = new BehaviorSubject<OperatingControlPointRowDto[]>([]);
  private loadingSubject = new BehaviorSubject<boolean>(false);
  public totalElements = new BehaviorSubject<number>(0);
  public pageSize = new BehaviorSubject<number>(10);
  public pageIndex = new BehaviorSubject<number>(0);
  public pointNameCriteria: string = '';
  public discriminantIdCriteria: number | null = null
  public departmentIdCriteria: number | null = null
  public loading$ = this.loadingSubject.asObservable();

  constructor(private operatingControlPointService: OperatingControlPointService) {}

  connect(collectionViewer: CollectionViewer): Observable<OperatingControlPointRowDto[]> {
    return this.pointsSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.pointsSubject.complete();
    this.loadingSubject.complete();
  }

  loadPoints(sortDirection = 'asc', pageIndex = -1, pageSize = -1) {
    if (pageSize == -1) {
      this.pageSize.next(10);
    } else {
      this.pageSize.next(pageSize)
    }

    if (pageIndex == -1) {
      this.pageIndex.next(0);
    } else {
      this.pageIndex.next(pageIndex)
    }
    this.loadingSubject.next(true);


    this.operatingControlPointService.getPage({pointName: this.pointNameCriteria, discriminantId: this.discriminantIdCriteria, departmentId: this.departmentIdCriteria}, sortDirection,
      this.pageIndex.getValue(), this.pageSize.getValue()).pipe(
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
