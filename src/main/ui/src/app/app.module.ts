import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';

import 'hammerjs';
import {MatButtonModule, MatCardModule, MatCheckboxModule, MatIconModule, MatInputModule} from '@angular/material';
import { TypingComponent } from './typing/typing.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { MenuComponent } from './menu/menu.component';
import {CustomModule} from './module/custom.module';
import {FormsModule} from '@angular/forms';
import {CountdownModule} from 'ngx-countdown';
import {HttpClientModule} from '@angular/common/http';
import { TypingConfigureComponent } from './typing-configure/typing-configure.component';
import { TypingContentComponent } from './typing-content/typing-content.component';

const appRoutes: Routes = [
  {path: 'typing', component: TypingComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    TypingComponent,
    MenuComponent,
    TypingConfigureComponent,
    TypingContentComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatIconModule,
    MatCardModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    FlexLayoutModule,
    CustomModule,
    FormsModule,
    CountdownModule,
    RouterModule.forRoot(appRoutes),
    NgbModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [
    CustomModule
  ]
})
export class AppModule { }
