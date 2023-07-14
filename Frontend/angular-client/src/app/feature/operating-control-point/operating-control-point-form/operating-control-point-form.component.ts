import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormGroup} from "@angular/forms";
import {FormlyFieldConfig} from "@ngx-formly/core";
import {OperatingControlPointService} from "../operating-control-point.service";
import {
  OperatingControlPointFormDto,
  OperatingControlPointRowDto
} from "../operating-control-point.model";
import {Discriminant} from "../../discriminant/discriminant";
import {DiscriminantService} from "../../discriminant/discriminant.service";
import {Observable} from "rxjs";
import {DepartmentService} from "../../department/department.service";
import {DepartmentRowDto} from "../../department/department.model";

@Component({
  selector: 'app-operating-control-point-form',
  templateUrl: './operating-control-point-form.component.html',
  styleUrls: ['./operating-control-point-form.component.css']
})
export class OperatingControlPointFormComponent implements OnInit{

  constructor(
    @Inject(MAT_DIALOG_DATA) public inputData: OperatingControlPointRowDto,
    private dialogRef: MatDialogRef<OperatingControlPointFormComponent>,
    private operatingControlPointService: OperatingControlPointService,
    private discriminantService: DiscriminantService,
    private railwayDepartmentService: DepartmentService
  ) {}

  form = new FormGroup({});

  model!: OperatingControlPointFormDto;

  discriminants: Observable<Discriminant[]> = this.discriminantService.getDiscriminant();
  railwayDepartents: Observable<DepartmentRowDto[]> = this.railwayDepartmentService.getDepartments();
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
                placeholder: 'Id',
                readonly: true
              },
              expressions: {
                hide: '!model.id',
              },
            },
            {
              key: 'pointName',
              type: 'input',
              props: {
                label: 'Point name',
                placeholder: 'Point name',
                required: true,
                readonly: false,
                maxLength: 255
              }
            },
            {
              key: 'discriminant.id',
              type: 'select',
              props: {
                label: 'Discriminant',
                options: this.discriminants,
                valueProp: 'id',
                labelProp: 'shortcut',
                required: true
              }
            },
            {
              key: 'railwayDepartment.id',
              type: 'select',
              props: {
                label: 'Railway Department',
                options: this.railwayDepartents,
                valueProp: 'id',
                labelProp: 'name',
                required: true
              }
            },
            {
              key: 'Loading Point',
              type: 'checkbox',
              props: {
                label: 'loadingPoint',
                indeterminate: false
              }
            },
          ],
        },
        {
          //TODO Po dodaniu encji z peronami wyświetlać listę peronów z możliwością edycji każdego rekordu, dodania, usunięcia
          props: { label: 'Platforms' },
          fieldGroup: [
            {
              key: 'platform',
              type: 'input',
              props: {
                label: 'Platform',
                required: false,
              },
            },
          ],
        },
      ],
    },
  ];

  ngOnInit(): void {
    if (this.inputData.id !== undefined){
      this.operatingControlPointService.getOne(this.inputData.id).subscribe({
        next: value => {
          this.model = value;
        }
      })
    } else {
      this.model = new OperatingControlPointFormDto();
      this.model.pointName = '';
    }

  }
  onSubmit() {
    if (this.form.valid) {
      this.dialogRef.close(this.model);
      if (typeof (this.model.id) !== 'undefined') {
        this.operatingControlPointService.update(this.model);
      } else {
        this.operatingControlPointService.create(this.model);
      }
    }
    this.dialogRef.close(this.model);
  }

  canDelete(): boolean {
    return typeof(this.inputData.id) !== 'undefined';
  }

  delete(): void {
    this.operatingControlPointService.delete(this.model.id);
    this.dialogRef.close(this.model);
  }

}
