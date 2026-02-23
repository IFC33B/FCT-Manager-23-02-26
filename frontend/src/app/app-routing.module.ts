import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';

const routes: Routes = [
  { path: 'login', loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule) },
  {
    path: '',
    component: MainLayoutComponent,
    canActivate: [AuthGuard],
    children: [
      { path: 'dashboard', loadChildren: () => import('./modules/dashboard/dashboard.module').then(m => m.DashboardModule) },
      { path: 'alumnes', loadChildren: () => import('./modules/alumnes/alumnes.module').then(m => m.AlumnesModule) },
      { path: 'empreses', loadChildren: () => import('./modules/empreses/empreses.module').then(m => m.EmpresesModule) },
      { path: 'tutors', loadChildren: () => import('./modules/tutors/tutors.module').then(m => m.TutorsModule) },
      { path: 'cicles', loadChildren: () => import('./modules/cicles/cicles.module').then(m => m.CiclesModule) },
      { path: 'convenis', loadChildren: () => import('./modules/convenis/convenis.module').then(m => m.ConvenisModule) },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
    ]
  },
  { path: '**', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
