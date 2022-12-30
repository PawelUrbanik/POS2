import {ConfigOption, FormlyFieldConfig} from "@ngx-formly/core";
import {AbstractControl, ValidationErrors} from "@angular/forms";

export const FORM_CONFIG: ConfigOption = {
  validators: [{name: 'onlyLetters', validation: LetterValidator}],
  validationMessages: [
    {name: 'required', message: 'This field is required'},
    {name: 'onlyLetters', message: LetterValidatorMessage }
  ]
};

export function LetterValidator(control: AbstractControl): ValidationErrors|null {
  return !control.value || /^[A-Za-z]+$/.test(control.value) ? null : { 'onlyLetters': true };
}

export function LetterValidatorMessage(error: any, field: FormlyFieldConfig) {
  return `Only letters are required`;
}

