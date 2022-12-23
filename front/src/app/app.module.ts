import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { TabelaTransferenciaComponent } from './tabela-transferencia/tabela-transferencia.component';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatAutocompleteModule } from '@angular/material/autocomplete';

@NgModule({
  declarations: [
    AppComponent,
    TabelaTransferenciaComponent,
  ],
  imports: [
    BrowserModule,
    MatTableModule,
    MatAutocompleteModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
