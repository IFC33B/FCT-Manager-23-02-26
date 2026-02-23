import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Tutor } from '../../../core/models/tutor.model';
import { Empresa } from '../../../core/models/empresa.model';
import { EmpresesService } from '../../../core/services/empreses.service';

@Component({
  selector: 'app-tutors-form',
  standalone: false,
  templateUrl: './tutors-form.component.html'
})
export class TutorsFormComponent implements OnInit {
  form: FormGroup;
  isEdit: boolean;
  empreses: Empresa[] = [];
  tipusList = ['EMPRESA', 'CENTRE'];

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<TutorsFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Tutor | null,
    private empresesService: EmpresesService
  ) {
    this.isEdit = !!data;
    this.form = this.fb.group({
      nom: [data?.nom || '', Validators.required],
      cognom: [data?.cognom || '', Validators.required],
      email: [data?.email || '', [Validators.required, Validators.email]],
      telefon: [data?.telefon || ''],
      carrec: [data?.carrec || ''],
      tipus: [data?.tipus || 'CENTRE', Validators.required],
      empresaId: [data?.empresa?.id || null]
    });
  }

  ngOnInit(): void {
    this.empresesService.getAll().subscribe(e => this.empreses = e);
  }

  onSubmit(): void {
    if (this.form.invalid) return;
    const val = this.form.value;
    const result: any = {
      nom: val.nom, cognom: val.cognom, email: val.email,
      telefon: val.telefon, carrec: val.carrec, tipus: val.tipus
    };
    if (val.empresaId) result.empresa = { id: val.empresaId };
    this.dialogRef.close(result);
  }

  onCancel(): void { this.dialogRef.close(); }
}
