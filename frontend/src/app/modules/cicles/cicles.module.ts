import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { CiclesListComponent } from './cicles-list/cicles-list.component';
import { CiclesFormComponent } from './cicles-form/cicles-form.component';

const routes: Routes = [{ path: '', component: CiclesListComponent }];

@NgModule({
  declarations: [CiclesListComponent, CiclesFormComponent],
  imports: [SharedModule, ReactiveFormsModule, RouterModule.forChild(routes)]
})
export class CiclesModule {}
