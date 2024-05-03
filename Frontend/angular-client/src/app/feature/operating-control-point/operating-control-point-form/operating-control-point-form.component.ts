import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormGroup} from "@angular/forms";
import {FormlyFieldConfig} from "@ngx-formly/core";
import {OperatingControlPointService} from "../operating-control-point.service";
import {
  OperatingControlPointFormDto,
  OperatingControlPointRowDto, PlatformOptionDto
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
export class OperatingControlPointFormComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public inputData: OperatingControlPointRowDto,
    private dialogRef: MatDialogRef<OperatingControlPointFormComponent>,
    private operatingControlPointService: OperatingControlPointService,
    private discriminantService: DiscriminantService,
    private railwayDepartmentService: DepartmentService
  ) {
  }

  form = new FormGroup({});

  model!: OperatingControlPointFormDto;

  discriminants: Observable<Discriminant[]> = this.discriminantService.getDiscriminant();
  railwayDepartments: Observable<DepartmentRowDto[]> = this.railwayDepartmentService.getDepartments();
  platforms: Observable<PlatformOptionDto[]> = new Observable<PlatformOptionDto[]>();
  fields: FormlyFieldConfig[] = [
    {
      type: 'tabs',
      fieldGroup: [
        {
          props: {label: 'General'},
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
                options: this.railwayDepartments,
                valueProp: 'id',
                labelProp: 'name',
                required: true
              }
            },
            {
              key: 'loadingPoint',
              type: 'checkbox',
              props: {
                label: 'Loading Point',
                indeterminate: false
              }
            },
            {
              key: 'otherManager',
              type: 'checkbox',
              props: {
                label: 'Other Manager',
                indeterminate: false
              }
            },
          ],
        },
        {
          props: {label: 'Platforms'},
          fieldGroup: [
            {
              key: 'platformData',
              type: 'platformsListForm',
              props: {
                dataSource: this.platforms
              },
            },
          ],
        },

      ],
    },
  ];

  ngOnInit(): void {
    if (this.inputData.id !== undefined) {
      this.operatingControlPointService.getOne(this.inputData.id).subscribe({
        next: value => {
          this.model = value;
        }
      });
      // this.operatingControlPointService.getPlatformsList(this.inputData.id)
      //   .subscribe(
      //     data => {
      //       this.platforms = data;
      //       this.initializeFormWithTable();
      //     }
      //   );
      // this.platforms = this.operatingControlPointService.getPlatformsList(this.inputData.id);
      // this.platforms.subscribe();
    } else {
      this.model = new OperatingControlPointFormDto();
      this.model.pointName = '';
    }

  }

  onSubmit() {
    if (this.form.valid) {
      if (typeof (this.model.id) !== 'undefined') {
        this.operatingControlPointService.update(this.model);
      } else {
        this.operatingControlPointService.create(this.model);
      }
    }
    setTimeout(() => {
      this.dialogRef.close(this.model);
    }, 500)
  }

  canDelete(): boolean {
    return typeof (this.inputData.id) !== 'undefined';
  }

  delete(): void {
    this.operatingControlPointService.delete(this.model.id);
    setTimeout(() => {
      this.dialogRef.close(this.model);
    }, 500)
  }

  initializeFormWithTable() {
    this.fields = [
      ...this.fields,
      {
        props: {label: 'Platforms'},
        fieldGroup: [
          {
            key: 'platformData',
            type: 'platformsListForm',
            props: {
              dataSource: this.platforms
            },
          },
        ],
      },
    ]
  }
}
