import {Component, OnInit, ViewChild} from '@angular/core';
import {Discriminant} from 'src/app/feature/discriminant/discriminant';
import {DiscriminantService} from 'src/app/feature/discriminant/discriminant.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog} from '@angular/material/dialog';
import {DiscriminantFormComponent} from "../discriminant-form/discriminant-form.component";


@Component({
  selector: 'app-discriminant-list',
  templateUrl: './discriminant-list.component.html',
  styleUrls: ['./discriminant-list.component.css']
})
export class DiscriminantListComponent implements OnInit {

  constructor(private discriminantService: DiscriminantService,
              public dialog: MatDialog) {
  }

  dataSource = new MatTableDataSource<Discriminant>();
  displayedColumns: string[] = ['id', 'shortcut', 'description'];

  @ViewChild(MatPaginator) paginator: MatPaginator;


  ngOnInit(): void {
    this.updateTable();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  getElement(row: Discriminant) {
    const formDialog = this.dialog.open(DiscriminantFormComponent,
      {
        data: {
          model: row
        }
      })

    formDialog.afterClosed().subscribe(
      value => {
        this.updateTable();
      })
  }

  updateTable() {
    this.discriminantService.getDiscriminant().subscribe(
      data => {
        this.dataSource = new MatTableDataSource<Discriminant>(data);
        this.dataSource.paginator = this.paginator;
      }
    );
  }

  create() {
    const dialogRef = this.dialog.open(DiscriminantFormComponent, {
      data: {
        model: new Discriminant(undefined, '', '')
      }
    });

    dialogRef.afterClosed().subscribe(()=> this.updateTable());
  }

}
