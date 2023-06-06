import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {OperatingControlPointService} from "../operating-control-point.service";
import {OperatingControlPointDatasource} from "./operating-control-point-datasource";
import {MatPaginator} from "@angular/material/paginator";
import {tap} from "rxjs/operators";
import {Discriminant} from "../../discriminant/discriminant";
import {MatDialog} from "@angular/material/dialog";
import {
  OperatingControlPointFormComponent
} from "../operating-control-point-form/operating-control-point-form.component";
import {DiscriminantFormComponent} from "../../discriminant/discriminant-form/discriminant-form.component";
import {OperatingControlPointRowDto} from "../operating-control-point.model";

@Component({
  selector: 'operating-control-point-list',
  templateUrl: './operating-control-point-list.component.html',
  styleUrls: ['./operating-control-point-list.component.css']
})
export class OperatingControlPointListComponent implements OnInit, AfterViewInit {

  dataSource: OperatingControlPointDatasource;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private service: OperatingControlPointService,
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
    this.dataSource = new OperatingControlPointDatasource(this.service);
    this.dataSource.loadPoints('', 'desc', 0 , 10);
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

  getElement(row: Discriminant) {
    const formDialog = this.dialog.open(OperatingControlPointFormComponent,
      {
        data: {
          model: row
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
