import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {OperatingControlPointRowDto} from "../operating-control-point.model";
import {OperatingControlPointService} from "../operating-control-point.service";
import {MatTableDataSource} from "@angular/material/table";
import {OperatingControlPointDatasource} from "./operating-control-point-datasource";
import {MatPaginator} from "@angular/material/paginator";
import {tap} from "rxjs/operators";

@Component({
  selector: 'operating-control-point-list',
  templateUrl: './operating-control-point-list.component.html',
  styleUrls: ['./operating-control-point-list.component.css']
})
export class OperatingControlPointListComponent implements OnInit, AfterViewInit {

  dataSource: OperatingControlPointDatasource;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private service: OperatingControlPointService
  ) { }

  displayedColumns = [
    'id',
    'pointName',
    'loadingPoint',
    'otherManager',
    'numberOfPlatforms',
    'discriminant',
    'railwayDepartment'
  ]

  ngOnInit(): void {
    this.dataSource = new OperatingControlPointDatasource(this.service);
    this.dataSource.loadPoints('', 'desc', 0 , 3);
  }

  ngAfterViewInit() {
    this.paginator.page
      .pipe(
        tap(() => this.loadPointsPage())
      )
      .subscribe();
  }

  loadPointsPage() {
    this.dataSource.loadPoints(
      '',
      'asc',
      this.paginator.pageIndex,
      this.paginator.pageSize);
  }

}
