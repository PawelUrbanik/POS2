import {Component, Inject} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {FormlyFieldConfig} from "@ngx-formly/core";
import {Discriminant} from "../discriminant";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DiscriminantService} from "../discriminant.service";

@Component({
  selector: 'app-discriminant-form',
  templateUrl: './discriminant-form.component.html',
  styleUrls: ['./discriminant-form.component.css']
})
export class DiscriminantFormComponent {

  constructor(
    @Inject(MAT_DIALOG_DATA) public inputData: any,
    private dialogRef: MatDialogRef<DiscriminantFormComponent>,
    private discriminantService: DiscriminantService
  ) {
    if (this.inputData)this.model = structuredClone(inputData.model);
  }

  form = new FormGroup({});

  model!: Discriminant;
  fields: FormlyFieldConfig[] = [
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
      key: 'shortcut',
      type: 'input',
      props: {
        label: 'shortcut',
        placeholder: 'shortcut',
        required: true,
        readonly: false
      }
    },
    {
      key: 'description',
      type: 'input',
      props: {
        label: 'desciption',
        placeholder: 'desciption',
        required: true,
        readonly: false
      }
    },
  ];

  onSubmit() {

    if (typeof(this.model.id) !== 'undefined') {
      this.discriminantService.updateDiscriminant(this.model);
    } else {
      this.discriminantService.createDiscriminant(this.model);
    }
    this.dialogRef.close(this.model);
  }

}
