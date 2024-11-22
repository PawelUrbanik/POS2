import { BehaviorSubject, Observable } from 'rxjs';
import {CollectionViewer, DataSource} from '@angular/cdk/collections';

export class PaginatedDataSource<T, Q> implements DataSource<T> {
  private dataSubject = new BehaviorSubject<T[]>([]);
  private countSubject = new BehaviorSubject<number>(0);
  private loadingSubject = new BehaviorSubject<boolean>(false);

  public data$: Observable<T[]> = this.dataSubject.asObservable();
  public count$: Observable<number> = this.countSubject.asObservable();
  public loading$: Observable<boolean> = this.loadingSubject.asObservable();

  private pageSize = 10;
  private pageIndex = 0;
  private query: Q | null = null;

  constructor(private fetchPage: (pageIndex: number, pageSize: number, query: Q | null) => Observable<{ data: T[]; count: number }>) {}

  connect(collectionViewer: CollectionViewer): Observable<T[]> {
    return this.dataSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.dataSubject.complete();
    this.countSubject.complete();
    this.loadingSubject.complete();
  }

  setPageIndex(pageIndex: number) {
    this.pageIndex = pageIndex;
    this.fetchData();
  }

  setPageSize(pageSize: number) {
    this.pageSize = pageSize;
    this.fetchData();
  }

  setQuery(query: Q) {
    this.query = query;
    this.fetchData();
  }

  fetchData() {
    this.loadingSubject.next(true);
    this.fetchPage(this.pageIndex, this.pageSize, this.query).subscribe((result) => {
      this.dataSubject.next(result.data);
      this.countSubject.next(result.count);
      this.loadingSubject.next(false);
    });
  }
}
