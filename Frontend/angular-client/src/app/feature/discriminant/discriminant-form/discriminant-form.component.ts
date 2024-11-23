import {Component, Inject} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {FormlyFieldConfig} from "@ngx-formly/core";
import {Discriminant} from "../discriminant";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {DiscriminantService} from "../discriminant.service";
import {ConfirmationDialogComponent} from "../../../core/components/confirmation-dialog/confirmation-dialog.component";

@Component({
  selector: 'app-discriminant-form',
  templateUrl: './discriminant-form.component.html',
  styleUrls: ['./discriminant-form.component.css']
})
export class DiscriminantFormComponent {

  constructor(
    @Inject(MAT_DIALOG_DATA) public inputData: any,
    private dialogRef: MatDialogRef<DiscriminantFormComponent>,
    private discriminantService: DiscriminantService,
    private dialog: MatDialog
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
        readonly: false,
        maxLength: 4
      },
      validators: {
          validation: ['onlyLetters']
      }
    },
    {
      key: 'description',
      type: 'input',
      props: {
        label: 'description',
        placeholder: 'description',
        required: true,
        readonly: false,
        maxLength: 255
      }
    },
  ];

  onSubmit() {
    if (this.form.valid) {
      this.dialogRef.close(this.model);
      if (typeof (this.model.id) !== 'undefined') {
        this.discriminantService.updateDiscriminant(this.model);
      } else {
        this.discriminantService.createDiscriminant(this.model);
      }
    }
    this.dialogRef.close(this.model);
  }

  canDelete(): boolean {
    return typeof(this.model.id) !== 'undefined';
  }

  deleteDiscriminant(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent,{
      data: {
        message: 'Are you sure to delete '+ this.model.shortcut + ' discriminant?'
      }
    })
    dialogRef.afterClosed().subscribe((value)=> {
      if (value) {
        this.discriminantService.deleteDiscriminant(this.model.id);
        this.dialogRef.close(this.model);
      }
    })
  }

}
