import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { CurriculosComponent } from './curriculos/curriculos.component';
import { VagasComponent } from './vagas/vagas.component';
import { PainelVagasComponent } from './painel-vagas/painel-vagas.component';

const routes: Routes = [
  { path: '', component: InicioComponent }, // Rota para a página inicial
  { path: 'curriculos', component: CurriculosComponent }, // Rota para currículos
  { path: 'vagas', component: VagasComponent }, // Rota para vagas
  { path: 'painel', component: PainelVagasComponent }, // Rota para painel vagas
  ];
  
  @NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  })
  export class AppRoutingModule { }
