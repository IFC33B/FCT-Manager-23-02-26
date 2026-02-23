import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cicle } from '../../../core/models/cicle.model';
import { CiclesService } from '../../../core/services/cicles.service';
import { CiclesFormComponent } from '../cicles-form/cicles-form.component';
import { ConfirmDialogComponent } from '../../../shared/components/confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-cicles-list',
  standalone: false,
  templateUrl: './cicles-list.component.html'
})
export class CiclesListComponent implements OnInit {
  displayedColumns = ['codi', 'nom', 'grau', 'familiaProfessional', 'accions'];
  dataSource = new MatTableDataSource<Cicle>();
  loading = true;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private ciclesService: CiclesService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void { this.loadData(); }

  loadData(): void {
    this.loading = true;
    this.ciclesService.getAll().subscribe({
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
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  openForm(cicle?: Cicle): void {
    const ref = this.dialog.open(CiclesFormComponent, {
      width: '500px',
      data: cicle || null
    });
    ref.afterClosed().subscribe(result => {
      if (!result) return;
      if (cicle?.id) {
        this.ciclesService.update(cicle.id, result).subscribe({
          next: () => { this.snackBar.open('Cicle actualitzat', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en actualitzar', '', { duration: 3000 })
        });
      } else {
        this.ciclesService.create(result).subscribe({
          next: () => { this.snackBar.open('Cicle creat', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en crear', '', { duration: 3000 })
        });
      }
    });
  }

  delete(cicle: Cicle): void {
    const ref = this.dialog.open(ConfirmDialogComponent, {
      data: { title: 'Eliminar Cicle', message: `Segur que vols eliminar "${cicle.nom}"?` }
    });
    ref.afterClosed().subscribe(confirmed => {
      if (!confirmed) return;
      this.ciclesService.delete(cicle.id!).subscribe({
        next: () => { this.snackBar.open('Cicle eliminat', '', { duration: 3000 }); this.loadData(); },
        error: () => this.snackBar.open('Error en eliminar', '', { duration: 3000 })
      });
    });
  }
}
