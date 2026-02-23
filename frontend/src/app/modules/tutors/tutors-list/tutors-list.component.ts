import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Tutor } from '../../../core/models/tutor.model';
import { TutorsService } from '../../../core/services/tutors.service';
import { TutorsFormComponent } from '../tutors-form/tutors-form.component';
import { ConfirmDialogComponent } from '../../../shared/components/confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-tutors-list',
  standalone: false,
  templateUrl: './tutors-list.component.html'
})
export class TutorsListComponent implements OnInit {
  displayedColumns = ['nom', 'cognom', 'email', 'telefon', 'carrec', 'tipus', 'empresa', 'accions'];
  dataSource = new MatTableDataSource<Tutor>();
  loading = true;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private tutorsService: TutorsService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void { this.loadData(); }

  loadData(): void {
    this.loading = true;
    this.tutorsService.getAll().subscribe({
      next: data => {
        this.dataSource.data = data;
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.loading = false;
      },
      error: () => this.loading = false
    });
  }

  applyFilter(event: Event): void {
    this.dataSource.filter = (event.target as HTMLInputElement).value.trim().toLowerCase();
  }

  openForm(tutor?: Tutor): void {
    const ref = this.dialog.open(TutorsFormComponent, { width: '600px', data: tutor || null });
    ref.afterClosed().subscribe(result => {
      if (!result) return;
      if (tutor?.id) {
        this.tutorsService.update(tutor.id, result).subscribe({
          next: () => { this.snackBar.open('Tutor actualitzat', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en actualitzar', '', { duration: 3000 })
        });
      } else {
        this.tutorsService.create(result).subscribe({
          next: () => { this.snackBar.open('Tutor creat', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en crear', '', { duration: 3000 })
        });
      }
    });
  }

  delete(tutor: Tutor): void {
    const ref = this.dialog.open(ConfirmDialogComponent, {
      data: { title: 'Eliminar Tutor', message: `Segur que vols eliminar "${tutor.nom} ${tutor.cognom}"?` }
    });
    ref.afterClosed().subscribe(confirmed => {
      if (!confirmed) return;
      this.tutorsService.delete(tutor.id!).subscribe({
        next: () => { this.snackBar.open('Tutor eliminat', '', { duration: 3000 }); this.loadData(); },
        error: () => this.snackBar.open('Error en eliminar', '', { duration: 3000 })
      });
    });
  }
}
