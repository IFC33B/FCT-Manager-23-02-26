import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Conveni } from '../../../core/models/conveni.model';
import { ConvenisService } from '../../../core/services/convenis.service';
import { ConvenisFormComponent } from '../convenis-form/convenis-form.component';
import { ConfirmDialogComponent } from '../../../shared/components/confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-convenis-list',
  standalone: false,
  templateUrl: './convenis-list.component.html'
})
export class ConvenisListComponent implements OnInit {
  displayedColumns = ['alumne', 'empresa', 'tutorEmpresa', 'tutorCentre', 'dataInici', 'dataFi', 'horesTotals', 'estat', 'accions'];
  dataSource = new MatTableDataSource<Conveni>();
  loading = true;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private convenisService: ConvenisService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void { this.loadData(); }

  loadData(): void {
    this.loading = true;
    this.convenisService.getAll().subscribe({
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

  getEstatColor(estat: string): string {
    const colors: Record<string, string> = {
      'PENDENT': 'accent', 'ACTIU': 'primary',
      'FINALITZAT': '', 'CANCEL\u00b7LAT': 'warn'
    };
    return colors[estat] || '';
  }

  openForm(conveni?: Conveni): void {
    const ref = this.dialog.open(ConvenisFormComponent, { width: '800px', data: conveni || null });
    ref.afterClosed().subscribe(result => {
      if (!result) return;
      if (conveni?.id) {
        this.convenisService.update(conveni.id, result).subscribe({
          next: () => { this.snackBar.open('Conveni actualitzat', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en actualitzar', '', { duration: 3000 })
        });
      } else {
        this.convenisService.create(result).subscribe({
          next: () => { this.snackBar.open('Conveni creat', '', { duration: 3000 }); this.loadData(); },
          error: () => this.snackBar.open('Error en crear', '', { duration: 3000 })
        });
      }
    });
  }

  delete(conveni: Conveni): void {
    const ref = this.dialog.open(ConfirmDialogComponent, {
      data: { title: 'Eliminar Conveni', message: `Segur que vols eliminar el conveni de "${conveni.alumne?.nom} ${conveni.alumne?.cognom}"?` }
    });
    ref.afterClosed().subscribe(confirmed => {
      if (!confirmed) return;
      this.convenisService.delete(conveni.id!).subscribe({
        next: () => { this.snackBar.open('Conveni eliminat', '', { duration: 3000 }); this.loadData(); },
        error: () => this.snackBar.open('Error en eliminar', '', { duration: 3000 })
      });
    });
  }
}
