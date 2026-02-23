import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Alumne } from '../../../core/models/alumne.model';
import { AlumnesService } from '../../../core/services/alumnes.service';
import { AlumnesFormComponent } from '../alumnes-form/alumnes-form.component';
import { ConfirmDialogComponent } from '../../../shared/components/confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-alumnes-list',
  standalone: false,
  templateUrl: './alumnes-list.component.html'
})
export class AlumnesListComponent implements OnInit {
  displayedColumns = ['nom', 'cognom', 'dni', 'email', 'cicle', 'cursEscolar', 'accions'];
  dataSource = new MatTableDataSource<Alumne>();
  loading = true;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private alumnesService: AlumnesService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void { this.loadData(); }

  loadData(): void {
    this.loading = true;
    this.alumnesService.getAll().subscribe({
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

  openForm(alumne?: Alumne): void {
    const ref = this.dialog.open(AlumnesFormComponent, { width: '700px', data: alumne || null });
    ref.afterClosed().subscribe(result => {
      if (!result) return;
      if (alumne?.id) {
        this.alumnesService.update(alumne.id, result).subscribe({
          next: () => { this.snackBar.open('Alumne actualitzat', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en actualitzar', '', { duration: 3000 })
        });
      } else {
        this.alumnesService.create(result).subscribe({
          next: () => { this.snackBar.open('Alumne creat', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en crear', '', { duration: 3000 })
        });
      }
    });
  }

  delete(alumne: Alumne): void {
    const ref = this.dialog.open(ConfirmDialogComponent, {
      data: { title: 'Eliminar Alumne', message: `Segur que vols eliminar "${alumne.nom} ${alumne.cognom}"?` }
    });
    ref.afterClosed().subscribe(confirmed => {
      if (!confirmed) return;
      this.alumnesService.delete(alumne.id!).subscribe({
        next: () => { this.snackBar.open('Alumne eliminat', '', { duration: 3000 }); this.loadData(); },
        error: () => this.snackBar.open('Error en eliminar', '', { duration: 3000 })
      });
    });
  }
}
