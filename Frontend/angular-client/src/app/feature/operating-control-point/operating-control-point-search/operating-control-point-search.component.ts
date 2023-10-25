import {Component, Input} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {FormlyFieldConfig, FormlyFormOptions} from "@ngx-formly/core";
import {DiscriminantService} from "../../discriminant/discriminant.service";
import {DepartmentService} from "../../department/department.service";
import {Observable} from "rxjs";
import {Discriminant} from "../../discriminant/discriminant";
import {DepartmentRowDto} from "../../department/department.model";
import {OperatingControlPointDatasource} from "../operating-control-point-list/operating-control-point-datasource";
import {OperatingControlPointService} from "../operating-control-point.service";

@Component({
  selector: 'operating-control-point-search',
  templateUrl: './operating-control-point-search.component.html',
  styleUrls: ['./operating-control-point-search.component.css']
})
export class OperatingControlPointSearchComponent {

  @Input()dataSource!: OperatingControlPointDatasource;


  constructor(
    private discriminantService: DiscriminantService,
    private railwayDepartmentService: DepartmentService,
  ) {
  }

  discriminants: Observable<Discriminant[]> = this.discriminantService.getDiscriminant();
  railwayDepartments: Observable<DepartmentRowDto[]> = this.railwayDepartmentService.getDepartments();
  form = new FormGroup({});
  model = {};
  options: FormlyFormOptions = {};

  fields: FormlyFieldConfig[] = [
    {
      fieldGroupClassName: 'row justify-content-center',
      fieldGroup: [
        {
          key: 'pointName',
          type: 'input',
          className: 'col-4',
          props: {
            placeholder: 'Name',
            keyup: (field, event) =>
            {
              this.dataSource.pointNameCriteria = field.formControl?.value ? field.formControl?.value : ''
              this.dataSource.loadPoints(  'asc',
                  0,
                  this.dataSource.pageSize.getValue());
            }
          },
        },
        {
          className: 'col-4',
          type: 'select',
          key: 'discriminantId',
          props: {
            placeholder: 'Discriminant',
            options: this.discriminants,
            valueProp: 'id',
            labelProp: 'shortcut',
            change: field => {
              this.dataSource.discriminantIdCriteria = field.formControl?.value;
              this.dataSource.loadPoints(  'asc',
                  0,
                  this.dataSource.pageSize.getValue());

            }
          },
        },
        {
          className: 'col-4',
          type: 'select',
          key: 'departmentId',
          props: {
            placeholder: 'Department',
            options: this.railwayDepartments,
            valueProp: 'id',
            labelProp: 'name',
            change: field => {
              this.dataSource.departmentIdCriteria = field.formControl?.value;
              this.dataSource.loadPoints(  'asc',
                  0,
                  this.dataSource.pageSize.getValue());
            }
          },
        },
      ],
    },
  ];

  onModelChange() {
  }

  reset() {
    this.model={};
  }
}
