import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Discriminant } from 'src/app/feature/discriminant/discriminant';
import { DiscriminantService } from 'src/app/feature/discriminant/discriminant.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog} from '@angular/material/dialog';
import {DiscriminantFormComponent} from "../discriminant-form/discriminant-form.component";



@Component({
  selector: 'app-discriminant-list',
  templateUrl: './discriminant-list.component.html',
  styleUrls: ['./discriminant-list.component.css']
})
export class DiscriminantListComponent implements OnInit  {

  constructor(private discriminantService: DiscriminantService,
              public dialog: MatDialog) { }

  dataSource = new MatTableDataSource<Discriminant>();
  displayedColumns: string[] = ['id', 'shortcut', 'description'];

  @ViewChild(MatPaginator) paginator: MatPaginator;


  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
    this.discriminantService.getDiscriminant().subscribe(data =>{
        console.log(data);
        this.dataSource = new MatTableDataSource<Discriminant>(data);
        this.dataSource.paginator = this.paginator;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  getElement(row: Discriminant) {
    console.log(row);
    const formDialog = this.dialog.open(DiscriminantFormComponent,
      {
        data: {
          data: row
        }
      })
  }


}