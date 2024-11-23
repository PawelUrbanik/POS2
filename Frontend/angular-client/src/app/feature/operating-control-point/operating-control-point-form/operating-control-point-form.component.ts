import { Component, Inject, OnInit } from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import { FormGroup } from '@angular/forms';
import { FormlyFieldConfig } from '@ngx-formly/core';
import { OperatingControlPointService } from '../operating-control-point.service';
import {
  OperatingControlPointFormDto,
  OperatingControlPointRowDto,
  PlatformRowDto,
} from '../operating-control-point.model';
import { Discriminant } from '../../discriminant/discriminant';
import { DiscriminantService } from '../../discriminant/discriminant.service';
import {BehaviorSubject, Observable} from 'rxjs';
import { DepartmentService } from '../../department/department.service';
import { DepartmentRowDto } from '../../department/department.model';
import { MatTableDataSource } from '@angular/material/table';
import {count, map, switchMap} from "rxjs/operators";
import {ConfirmationDialogComponent} from "../../../core/components/confirmation-dialog/confirmation-dialog.component";

@Component({
  selector: 'app-operating-control-point-form',
  templateUrl: './operating-control-point-form.component.html',
  styleUrls: ['./operating-control-point-form.component.css'],
})
export class OperatingControlPointFormComponent implements OnInit {
  constructor(
    @Inject(MAT_DIALOG_DATA) public inputData: OperatingControlPointRowDto,
    private dialogRef: MatDialogRef<OperatingControlPointFormComponent>,
    private operatingControlPointService: OperatingControlPointService,
    private discriminantService: DiscriminantService,
    private railwayDepartmentService: DepartmentService,
    private dialog: MatDialog
  ) {}

  form = new FormGroup({});
  model!: OperatingControlPointFormDto;

  private refreshSubject = new BehaviorSubject<void>(undefined);
  discriminants: Observable<Discriminant[]> = this.discriminantService.getDiscriminant();
  railwayDepartments: Observable<DepartmentRowDto[]> = this.railwayDepartmentService.getDepartments();
  platforms: Observable<PlatformRowDto[]> = new Observable<PlatformRowDto[]>();

  fields: FormlyFieldConfig[] = [
    {
      type: 'tabs',
      fieldGroup: [
        {
          props: { label: 'General' },
          fieldGroup: [
            {
              key: 'id',
              type: 'input',
              props: {
                label: 'ID',
                readonly: true,
              },
              expressions: {
                hide: '!model.id',
              },
            },
            {
              key: 'pointName',
              type: 'input',
              props: {
                label: 'Point Name',
                placeholder: 'Point name',
                required: true,
                maxLength: 255,
              },
            },
            {
              key: 'discriminant.id',
              type: 'select',
              props: {
                label: 'Discriminant',
                options: this.discriminants,
                valueProp: 'id',
                labelProp: 'shortcut',
                required: true,
              },
            },
            {
              key: 'railwayDepartment.id',
              type: 'select',
              props: {
                label: 'Railway Department',
                options: this.railwayDepartments,
                valueProp: 'id',
                labelProp: 'name',
                required: true,
              },
            },
            {
              key: 'loadingPoint',
              type: 'checkbox',
              defaultValue: false,
              props: {
                label: 'Loading Point',
              },
            },
            {
              key: 'otherManager',
              type: 'checkbox',
              defaultValue: false,
              props: {
                label: 'Other Manager',
              },
            },
          ],
        },
        {
          props: { label: 'Platforms' },
          fieldGroup: [
            {
              key: 'platformData',
              type: 'platformsListForm',
              props: {
                dataSource: new MatTableDataSource([]), // Puste dane, które zostaną zaktualizowane
              },
              hooks: {
                onInit: (field) => {
                  this.platforms.subscribe((data) => {
                    if (field.props) {
                      field.props.dataSource = new MatTableDataSource(data);
                    }
                  });
                },
              }
            },
          ],
        },
      ],
    },
  ];

  ngOnInit(): void {
    // Jeśli istnieje ID, pobierz dane
    if (this.inputData.id !== undefined) {
      this.operatingControlPointService.getOne(this.inputData.id).subscribe({
        next: (value) => {
          this.model = value;
        },
      });
      // this.platforms = this.operatingControlPointService.getPlatformsList(this.inputData.id);
      this.platforms = this.refreshSubject.asObservable().pipe(
        switchMap(()=> this.operatingControlPointService.getPlatformsList(this.inputData.id))
      );
    } else {
      this.model = new OperatingControlPointFormDto();
      this.model.pointName = '';
    }
  }

  onSubmit() {
    if (this.form.valid) {
      if (typeof this.model.id !== 'undefined') {
        this.operatingControlPointService.update(this.model);
      } else {
        this.operatingControlPointService.create(this.model);
      }
      this.dialogRef.close(this.model);
    }
  }

  delete(): void {
    const confirmDialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {
        message: 'Are you sure to delete '+ this.model.pointName + ' operating control point?'
      }
    })

    confirmDialogRef.afterClosed().subscribe(
      (value) => {
        if (value) {
          if (this.inputData.id) {
            this.operatingControlPointService.delete(this.model.id).subscribe(() => {
              this.dialogRef.close(this.model);
            });
          }
        }
      }
    )
  }
  canDelete(): boolean {
    return typeof this.inputData.id !== 'undefined';
  }

  public refreshPlatformData(){
    this.refreshSubject.next();
  }
}
