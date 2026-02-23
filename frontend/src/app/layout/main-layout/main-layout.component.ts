import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-main-layout',
  standalone: false,
  templateUrl: './main-layout.component.html',
  styleUrls: ['./main-layout.component.scss']
})
export class MainLayoutComponent {
  menuItems = [
    { label: 'Dashboard', icon: 'dashboard', route: '/dashboard' },
    { label: 'Alumnes', icon: 'school', route: '/alumnes' },
    { label: 'Empreses', icon: 'business', route: '/empreses' },
    { label: 'Tutors', icon: 'person', route: '/tutors' },
    { label: 'Cicles', icon: 'book', route: '/cicles' },
    { label: 'Convenis', icon: 'description', route: '/convenis' },
  ];

  constructor(public auth: AuthService, private router: Router) {}

  logout(): void {
    this.auth.logout();
  }

  get currentUser() {
    return this.auth.getCurrentUser();
  }
}
