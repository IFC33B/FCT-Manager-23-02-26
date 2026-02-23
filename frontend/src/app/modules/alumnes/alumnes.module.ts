import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { AlumnesListComponent } from './alumnes-list/alumnes-list.component';
import { AlumnesFormComponent } from './alumnes-form/alumnes-form.component';

const routes: Routes = [{ path: '', component: AlumnesListComponent }];

@NgModule({
  declarations: [AlumnesListComponent, AlumnesFormComponent],
  imports: [SharedModule, ReactiveFormsModule, RouterModule.forChild(routes)]
})
export class AlumnesModule {}
