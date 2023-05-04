import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormGroup} from "@angular/forms";
import {FormlyFieldConfig} from "@ngx-formly/core";
import {OperatingControlPointService} from "../operating-control-point.service";
import {OperatingControlPointRowDto} from "../operating-control-point.model";

@Component({
  selector: 'app-operating-control-point-form',
  templateUrl: './operating-control-point-form.component.html',
  styleUrls: ['./operating-control-point-form.component.css']
})
export class OperatingControlPointFormComponent {

  constructor(
    @Inject(MAT_DIALOG_DATA) public inputData: any,
    private dialogRef: MatDialogRef<OperatingControlPointFormComponent>,
    private operatingControlPointService: OperatingControlPointService
  ) {
    if (this.inputData)this.model = structuredClone(inputData.model);
  }

  form = new FormGroup({});

  model!: OperatingControlPointRowDto;
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
              }
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
              // TODO request to download list of discriminants
              key: 'discriminant',
              type: 'input',
              props: {
                label: 'discriminant',
              }
            },
            {
              // TODO request to download list of railwayDepartments
              key: 'railwayDepartment',
              type: 'input',
              props: {
                label: 'railwayDepartment',
              }
            },
            {
              key: 'loadingPoint',
              type: 'checkbox',
              props: {
                label: 'loadingPoint',
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
    return typeof(this.model.id) !== 'undefined';
  }

  delete(): void {
    this.operatingControlPointService.delete(this.model.id);
    this.dialogRef.close(this.model);
  }

}
