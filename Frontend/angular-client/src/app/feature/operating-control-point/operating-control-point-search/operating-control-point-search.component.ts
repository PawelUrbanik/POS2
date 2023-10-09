import { Component } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {FormlyFieldConfig, FormlyFormOptions} from "@ngx-formly/core";

@Component({
  selector: 'operating-control-point-search',
  templateUrl: './operating-control-point-search.component.html',
  styleUrls: ['./operating-control-point-search.component.css']
})
export class OperatingControlPointSearchComponent {

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
          },
        },
        {
          className: 'col-4',
          type: 'select',
          key: 'discriminantId',
          props: {
            placeholder: 'Discriminant',
            options: [
              { label: 'Opcja A', value: 'A' },
              { label: 'Opcja B', value: 'B' },
            ],
          },
        },
        {
          className: 'col-4',
          type: 'select',
          key: 'departmentId',
          props: {
            placeholder: 'Department',
            options: [
              { label: 'Opcja 1', value: '1' },
              { label: 'Opcja 2', value: '2' },
            ],
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
