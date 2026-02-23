import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { TutorsListComponent } from './tutors-list/tutors-list.component';
import { TutorsFormComponent } from './tutors-form/tutors-form.component';

const routes: Routes = [{ path: '', component: TutorsListComponent }];

@NgModule({
  declarations: [TutorsListComponent, TutorsFormComponent],
  imports: [SharedModule, ReactiveFormsModule, RouterModule.forChild(routes)]
})
export class TutorsModule {}
