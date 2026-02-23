import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Empresa } from '../../../core/models/empresa.model';
import { EmpresesService } from '../../../core/services/empreses.service';
import { EmpresesFormComponent } from '../empreses-form/empreses-form.component';
import { ConfirmDialogComponent } from '../../../shared/components/confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-empreses-list',
  standalone: false,
  templateUrl: './empreses-list.component.html'
})
export class EmpresesListComponent implements OnInit {
  displayedColumns = ['nom', 'cif', 'poblacio', 'telefon', 'email', 'sectorActivitat', 'accions'];
  dataSource = new MatTableDataSource<Empresa>();
  loading = true;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private empresesService: EmpresesService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void { this.loadData(); }

  loadData(): void {
    this.loading = true;
    this.empresesService.getAll().subscribe({
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

  openForm(empresa?: Empresa): void {
    const ref = this.dialog.open(EmpresesFormComponent, { width: '700px', data: empresa || null });
    ref.afterClosed().subscribe(result => {
      if (!result) return;
      if (empresa?.id) {
        this.empresesService.update(empresa.id, result).subscribe({
          next: () => { this.snackBar.open('Empresa actualitzada', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en actualitzar', '', { duration: 3000 })
        });
      } else {
        this.empresesService.create(result).subscribe({
          next: () => { this.snackBar.open('Empresa creada', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en crear', '', { duration: 3000 })
        });
      }
    });
  }

  delete(empresa: Empresa): void {
    const ref = this.dialog.open(ConfirmDialogComponent, {
      data: { title: 'Eliminar Empresa', message: `Segur que vols eliminar "${empresa.nom}"?` }
    });
    ref.afterClosed().subscribe(confirmed => {
      if (!confirmed) return;
      this.empresesService.delete(empresa.id!).subscribe({
        next: () => { this.snackBar.open('Empresa eliminada', '', { duration: 3000 }); this.loadData(); },
        error: () => this.snackBar.open('Error en eliminar', '', { duration: 3000 })
      });
    });
  }
}
