import {Component, Input, OnInit} from '@angular/core';
import {OperatingControlPointRowDto} from "../operating-control-point.model";
import {OperatingControlPointService} from "../operating-control-point.service";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'operating-control-point-list',
  templateUrl: './operating-control-point-list.component.html',
  styleUrls: ['./operating-control-point-list.component.css']
})
export class OperatingControlPointListComponent implements OnInit {

  @Input() dataSource = new MatTableDataSource<OperatingControlPointRowDto>();
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
    this.updateTable();
  }

  private updateTable() {
    this.service.getPage(0,10).subscribe(
      response => {
        this.dataSource = new MatTableDataSource(response.content);
      }
    )
    this.dataSource.connect().subscribe();
  }
}
