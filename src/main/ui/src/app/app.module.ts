import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';

import 'hammerjs';
import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatIconModule,
  MatInputModule, MatPaginatorIntl, MatPaginatorModule,
  MatProgressSpinnerModule, MatSortModule, MatTableModule
} from '@angular/material';
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
import { AnalysisComponent } from './analysis/analysis.component';
import {chPaginator} from './module/ch-paginator';
import { WordDetailComponent } from './word-detail/word-detail.component';

const appRoutes: Routes = [
  {path: 'typing', component: TypingComponent},
  {path: 'analysis', component: AnalysisComponent},
  {path: 'word_detail', component: WordDetailComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    TypingComponent,
    MenuComponent,
    TypingConfigureComponent,
    TypingContentComponent,
    AnalysisComponent,
    WordDetailComponent
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
    MatProgressSpinnerModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    FlexLayoutModule,
    CustomModule,
    FormsModule,
    CountdownModule,
    RouterModule.forRoot(appRoutes),
    NgbModule.forRoot()
  ],
  providers: [
    {provide: MatPaginatorIntl, useValue: chPaginator()}
  ],
  bootstrap: [AppComponent],
  exports: [
    CustomModule
  ]
})
export class AppModule { }
