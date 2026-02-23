import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Cicle } from '../../../core/models/cicle.model';

@Component({
  selector: 'app-cicles-form',
  standalone: false,
  templateUrl: './cicles-form.component.html'
})
export class CiclesFormComponent {
  form: FormGroup;
  isEdit: boolean;

  graus = ['CFGM', 'CFGS'];

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<CiclesFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Cicle | null
  ) {
    this.isEdit = !!data;
    this.form = this.fb.group({
      nom: [data?.nom || '', Validators.required],
      grau: [data?.grau || '', Validators.required],
      familiaProfessional: [data?.familiaProfessional || '', Validators.required],
      codi: [data?.codi || '', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.form.invalid) return;
    this.dialogRef.close(this.form.value);
  }

  onCancel(): void {
    this.dialogRef.close();
  }
}
