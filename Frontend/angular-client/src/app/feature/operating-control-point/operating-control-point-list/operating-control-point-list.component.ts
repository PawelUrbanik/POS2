import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {OperatingControlPointService} from "../operating-control-point.service";
import {OperatingControlPointDatasource} from "./operating-control-point-datasource";
import {MatPaginator} from "@angular/material/paginator";
import {tap} from "rxjs/operators";
import {Discriminant} from "../../discriminant/discriminant";
import {MatDialog} from "@angular/material/dialog";
import {
  OperatingControlPointFormComponent
} from "../operating-control-point-form/operating-control-point-form.component";
import {OperatingControlPointRowDto} from "../operating-control-point.model";

@Component({
  selector: 'operating-control-point-list',
  templateUrl: './operating-control-point-list.component.html',
  styleUrls: ['./operating-control-point-list.component.css']
})
export class OperatingControlPointListComponent implements OnInit, AfterViewInit {

  @Input()dataSource!: OperatingControlPointDatasource;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private dialog: MatDialog
  ) { }

  displayedColumns = [
    'id',
    'pointName',
    'loadingPoint',
    'otherManager',
    'numberOfPlatforms',
    'numberOfLines',
    'discriminant',
    'railwayDepartment'
  ]

  ngOnInit(): void {
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
      'asc',
      this.paginator.pageIndex,
        this.paginator.pageSize);
  }

  getElement(row: Discriminant) {
    const formDialog = this.dialog.open(OperatingControlPointFormComponent,
      {
        data: {
          id: row.id
        }
      })

    formDialog.afterClosed().subscribe(
      value => {
        this.loadPointsPage();
      })
  }

  create() {
    const dialogRef = this.dialog.open(OperatingControlPointFormComponent,
      {
        data: {
          model: new OperatingControlPointRowDto()
        }
      });

    dialogRef.afterClosed().subscribe(
      value => {
        this.loadPointsPage();
      }
    )

  }
}
