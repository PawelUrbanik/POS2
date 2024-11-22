import {Component, Inject, OnInit} from '@angular/core';
import {PlatformService} from "../platform.service";
import {FormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Platform} from "../platform.model";
import {FormlyFieldConfig} from "@ngx-formly/core";

@Component({
  selector: 'app-platform-form',
  templateUrl: './platform-form.component.html',
  styleUrls: ['./platform-form.component.css']
})
export class PlatformFormComponent implements OnInit{

  constructor(
    @Inject(MAT_DIALOG_DATA) public id: any,
    private dialogRef: MatDialogRef<PlatformFormComponent>,
    private platformService: PlatformService){
  }

  form = new FormGroup({});
  model!: Platform;
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
      key: 'platformNumber',
      type: 'input',
      props: {
        label: 'platformNumber',
        placeholder: 'platformNumber',
        required: true,
        readonly: false,
        maxLength: 4
      }
    },
    {
      key: 'height',
      type: 'number',
      props: {
        label: 'height',
        placeholder: 'height',
        required: true,
        readonly: false,
      }
    },
    {
      key: 'length',
      type: 'number',
      props: {
        label: 'length',
        placeholder: 'length',
        required: true,
        readonly: false,
      }
    },
    {
      key: 'requestStop',
      type: 'checkbox',
      defaultValue: false,
      props: {
        label: 'requestStop',
        placeholder: 'requestStop'
      }
    },
  ];

  onSubmit() {
    if (this.form.valid) {
      this.dialogRef.close(this.model);
      if (typeof (this.model.id) !== 'undefined') {
        this.platformService.updatePlatform(this.model).subscribe();
      } else {
        this.platformService.createPlatform(this.model);
      }
    }
    this.dialogRef.close(this.model);
  }

  canDelete(): boolean {
    return false
    // return typeof(this.model.id) !== 'undefined';
  }

  deletePlatform(): void {
    if (this.model.id !== undefined){
      this.platformService.deletePlatform(this.model.id);
    }
    this.dialogRef.close(this.model);
  }

  ngOnInit(): void {
    if (this.id === undefined) {
      this.model = {
        edges: [],
        height: 0,
        length: 0,
        requestStop: false,
        platformNumber: ''
      }
    } else {
      this.platformService.getOne(this.id.id).subscribe(
        {
          next: platform => this.model = platform
        }
      )
    }

  }

}
