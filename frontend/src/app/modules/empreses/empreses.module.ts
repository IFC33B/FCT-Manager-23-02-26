import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { EmpresesListComponent } from './empreses-list/empreses-list.component';
import { EmpresesFormComponent } from './empreses-form/empreses-form.component';

const routes: Routes = [{ path: '', component: EmpresesListComponent }];

@NgModule({
  declarations: [EmpresesListComponent, EmpresesFormComponent],
  imports: [SharedModule, ReactiveFormsModule, RouterModule.forChild(routes)]
})
export class EmpresesModule {}
