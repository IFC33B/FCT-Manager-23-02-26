import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../../core/services/dashboard.service';
import { DashboardStats } from '../../core/models/dashboard.model';

@Component({
  selector: 'app-dashboard',
  standalone: false,
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  stats: DashboardStats | null = null;
  loading = true;

  statCards = [
    { key: 'totalAlumnes', label: 'Alumnes', icon: 'school', color: '#1976d2' },
    { key: 'totalEmpreses', label: 'Empreses', icon: 'business', color: '#388e3c' },
    { key: 'totalTutors', label: 'Tutors', icon: 'person', color: '#f57c00' },
    { key: 'totalCicles', label: 'Cicles Formatius', icon: 'book', color: '#7b1fa2' },
    { key: 'convenisPendents', label: 'Convenis Pendents', icon: 'pending', color: '#fbc02d' },
    { key: 'convenisActius', label: 'Convenis Actius', icon: 'check_circle', color: '#43a047' },
    { key: 'convenisFinalitzats', label: 'Convenis Finalitzats', icon: 'done_all', color: '#546e7a' },
  ];

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.dashboardService.getStats().subscribe({
      next: data => { this.stats = data; this.loading = false; },
      error: () => { this.loading = false; }
    });
  }

  getValue(key: string): number {
    return this.stats ? (this.stats as any)[key] ?? 0 : 0;
  }
}
