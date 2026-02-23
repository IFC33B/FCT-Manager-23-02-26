import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { ConvenisListComponent } from './convenis-list/convenis-list.component';
import { ConvenisFormComponent } from './convenis-form/convenis-form.component';

const routes: Routes = [{ path: '', component: ConvenisListComponent }];

@NgModule({
  declarations: [ConvenisListComponent, ConvenisFormComponent],
  imports: [SharedModule, ReactiveFormsModule, RouterModule.forChild(routes)]
})
export class ConvenisModule {}
