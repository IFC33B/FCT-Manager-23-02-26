import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Alumne } from '../../../core/models/alumne.model';
import { Cicle } from '../../../core/models/cicle.model';
import { CiclesService } from '../../../core/services/cicles.service';

@Component({
  selector: 'app-alumnes-form',
  standalone: false,
  templateUrl: './alumnes-form.component.html'
})
export class AlumnesFormComponent implements OnInit {
  form: FormGroup;
  isEdit: boolean;
  cicles: Cicle[] = [];

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<AlumnesFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Alumne | null,
    private ciclesService: CiclesService
  ) {
    this.isEdit = !!data;
    this.form = this.fb.group({
      nom: [data?.nom || '', Validators.required],
      cognom: [data?.cognom || '', Validators.required],
      dni: [data?.dni || '', Validators.required],
      email: [data?.email || '', [Validators.required, Validators.email]],
      telefon: [data?.telefon || ''],
      poblacio: [data?.poblacio || ''],
      cursEscolar: [data?.cursEscolar || ''],
      cicleId: [data?.cicle?.id || null, Validators.required]
    });
  }

  ngOnInit(): void {
    this.ciclesService.getAll().subscribe(cicles => this.cicles = cicles);
  }

  onSubmit(): void {
    if (this.form.invalid) return;
    const val = this.form.value;
    const result: Alumne = {
      nom: val.nom, cognom: val.cognom, dni: val.dni,
      email: val.email, telefon: val.telefon, poblacio: val.poblacio,
      cursEscolar: val.cursEscolar,
      cicle: { id: val.cicleId } as any
    };
    this.dialogRef.close(result);
  }

  onCancel(): void { this.dialogRef.close(); }
}
