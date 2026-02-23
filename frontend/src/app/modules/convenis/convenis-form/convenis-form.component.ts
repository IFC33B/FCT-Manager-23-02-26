import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Conveni } from '../../../core/models/conveni.model';
import { Alumne } from '../../../core/models/alumne.model';
import { Empresa } from '../../../core/models/empresa.model';
import { Tutor } from '../../../core/models/tutor.model';
import { AlumnesService } from '../../../core/services/alumnes.service';
import { EmpresesService } from '../../../core/services/empreses.service';
import { TutorsService } from '../../../core/services/tutors.service';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-convenis-form',
  standalone: false,
  templateUrl: './convenis-form.component.html'
})
export class ConvenisFormComponent implements OnInit {
  form: FormGroup;
  isEdit: boolean;
  alumnes: Alumne[] = [];
  empreses: Empresa[] = [];
  tutorsEmpresa: Tutor[] = [];
  tutorsCentre: Tutor[] = [];
  estatsList = ['PENDENT', 'ACTIU', 'FINALITZAT', 'CANCEL\u00b7LAT'];

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<ConvenisFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Conveni | null,
    private alumnesService: AlumnesService,
    private empresesService: EmpresesService,
    private tutorsService: TutorsService
  ) {
    this.isEdit = !!data;
    this.form = this.fb.group({
      alumneId: [data?.alumne?.id || null, Validators.required],
      empresaId: [data?.empresa?.id || null, Validators.required],
      tutorEmpresaId: [data?.tutorEmpresa?.id || null, Validators.required],
      tutorCentreId: [data?.tutorCentre?.id || null, Validators.required],
      dataInici: [data?.dataInici || '', Validators.required],
      dataFi: [data?.dataFi || '', Validators.required],
      horesTotals: [data?.horesTotals || null, [Validators.required, Validators.min(1)]],
      estat: [data?.estat || 'PENDENT', Validators.required],
      observacions: [data?.observacions || '']
    });
  }

  ngOnInit(): void {
    forkJoin({
      alumnes: this.alumnesService.getAll(),
      empreses: this.empresesService.getAll(),
      tutors: this.tutorsService.getAll()
    }).subscribe(({ alumnes, empreses, tutors }) => {
      this.alumnes = alumnes;
      this.empreses = empreses;
      this.tutorsEmpresa = tutors.filter(t => t.tipus === 'EMPRESA');
      this.tutorsCentre = tutors.filter(t => t.tipus === 'CENTRE');
    });
  }

  onSubmit(): void {
    if (this.form.invalid) return;
    const val = this.form.value;
    const result: any = {
      alumne: { id: val.alumneId },
      empresa: { id: val.empresaId },
      tutorEmpresa: { id: val.tutorEmpresaId },
      tutorCentre: { id: val.tutorCentreId },
      dataInici: val.dataInici,
      dataFi: val.dataFi,
      horesTotals: val.horesTotals,
      estat: val.estat,
      observacions: val.observacions
    };
    this.dialogRef.close(result);
  }

  onCancel(): void { this.dialogRef.close(); }
}
