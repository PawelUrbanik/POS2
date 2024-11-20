import {Component, OnChanges, OnInit, SimpleChanges, ViewChild, ViewContainerRef} from '@angular/core';
import {FieldType} from '@ngx-formly/core';
import {MatTableDataSource} from '@angular/material/table';

import {
  OperatingControlPointFormComponent
} from "../../feature/operating-control-point/operating-control-point-form/operating-control-point-form.component";
import {PlatformRowDto} from "../../feature/operating-control-point/operating-control-point.model";
@Component({
  selector: 'platforms-list-form',
  template: `
    <div class="">
      <table mat-table #table [dataSource]="dataSource" class="mat-elevation-z8 wide-table">
        <!-- Columns -->
        <ng-container matColumnDef="platformNumber">
          <th mat-header-cell *matHeaderCellDef class="px-2"> Platform Number</th>
          <td mat-cell *matCellDef="let element" class="px-2"> {{ element.platformNumber }}</td>
        </ng-container>
        <ng-container matColumnDef="height">
          <th mat-header-cell *matHeaderCellDef class="px-4"> Height</th>
          <td mat-cell *matCellDef="let element" class="px-4"> {{ element.height }}</td>
        </ng-container>
        <ng-container matColumnDef="length">
          <th mat-header-cell *matHeaderCellDef class="px-2"> Length</th>
          <td mat-cell *matCellDef="let element" class="px-2"> {{ element.length }}</td>
        </ng-container>
        <ng-container matColumnDef="requestStop">
          <th mat-header-cell *matHeaderCellDef class="px-2"> Request Stop</th>
          <td mat-cell *matCellDef="let element" class="px-2"> {{ element.requestStop }}</td>
        </ng-container>
        <ng-container matColumnDef="numberOfEdges">
          <th mat-header-cell *matHeaderCellDef class="px-2"> Number of Edges</th>
          <td mat-cell *matCellDef="let element" class="px-2"> {{ element.numberOfEdges }}</td>
        </ng-container>

        <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
        <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
      </table>
    </div>
  `,
  styleUrls: [
    'customPlatformComponent.css'
  ]
})
export class CustomPlatformTableComponent extends FieldType {
  constructor(public viewContainerRef: ViewContainerRef) {
    super();
    const parent = this.viewContainerRef.injector.get(OperatingControlPointFormComponent, null);
    parent?.platforms.subscribe({
        next: value => {
          this.dataSource = new MatTableDataSource<any>(value)
        }
      }
    );
  }

  displayedColumns: string[] = [
    'platformNumber',
    'height',
    'length',
    'requestStop',
    'numberOfEdges',
  ];

  dataSource = new MatTableDataSource<PlatformRowDto[]>();

}
