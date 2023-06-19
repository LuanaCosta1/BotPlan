import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { HeaderComponent } from './components/header/header.component';
import { LoadingFullScreenComponent } from './components/loading-full-screen/loading-full-screen.component';


@NgModule({
  declarations: [
    HeaderComponent,
    LoadingFullScreenComponent
  ],
  imports: [
    CommonModule,
    SharedRoutingModule,
  ],
  exports: [
    HeaderComponent
  ]
})
export class SharedModule { }
