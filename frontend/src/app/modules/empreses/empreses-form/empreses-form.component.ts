import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Empresa } from '../../../core/models/empresa.model';

@Component({
  selector: 'app-empreses-form',
  standalone: false,
  templateUrl: './empreses-form.component.html'
})
export class EmpresesFormComponent {
  form: FormGroup;
  isEdit: boolean;

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<EmpresesFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Empresa | null
  ) {
    this.isEdit = !!data;
    this.form = this.fb.group({
      nom: [data?.nom || '', Validators.required],
      cif: [data?.cif || '', Validators.required],
      direccio: [data?.direccio || ''],
      poblacio: [data?.poblacio || ''],
      codiPostal: [data?.codiPostal || ''],
      provincia: [data?.provincia || ''],
      telefon: [data?.telefon || ''],
      email: [data?.email || '', Validators.email],
      web: [data?.web || ''],
      sectorActivitat: [data?.sectorActivitat || '']
    });
  }

  onSubmit(): void {
    if (this.form.invalid) return;
    this.dialogRef.close(this.form.value);
  }

  onCancel(): void { this.dialogRef.close(); }
}
