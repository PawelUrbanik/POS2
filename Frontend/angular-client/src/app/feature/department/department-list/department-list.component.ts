import {Component, OnInit} from '@angular/core';
import {DepartmentService} from "../department.service";
import {MatDialog} from '@angular/material/dialog';
import {MatTableDataSource} from "@angular/material/table";
import {DepartmentRowDto} from "../department.model";

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})
export class DepartmentListComponent implements OnInit{

  constructor(private departmentService: DepartmentService,
              public dialog: MatDialog) {
  }

  datasource = new MatTableDataSource<DepartmentRowDto>();
  displayedColumns = ['id', 'name'];

  ngOnInit() {
    this.updateTable();
  }


  private updateTable() {
    this.departmentService.getDepartments().subscribe(
      data => {
        this.datasource = new MatTableDataSource<DepartmentRowDto>(data);
      }
    )
  }
}
