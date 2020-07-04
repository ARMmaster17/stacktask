import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";

import { ListSelectorComponent } from './components/listselector.component';
import {AppContainerComponent} from "go/app/components/app.component";
import {TasklistComponent} from "go/app/components/tasklist.component";
import {TaskComponent} from "go/app/components/task.component";

@NgModule({
  declarations: [
    AppContainerComponent,
    ListSelectorComponent,
    TasklistComponent,
    TaskComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppContainerComponent]
})
export class AppModule { }
