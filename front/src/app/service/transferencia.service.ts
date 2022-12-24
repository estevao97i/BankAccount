import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Transferencia } from 'src/model/transferencia-model';
import { Observable } from 'rxjs';
import { TransferenciaFiltro } from '../../model/transferencia-filtro-model';

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {

  baseUrl = 'localhost:8080/transferencias/';

  constructor( private http: HttpClient) { }

  findAll(): Observable<Transferencia[]> {
    const url = `${this.baseUrl}`;
    return this.http.get<Transferencia[]>(url);
  }

  findByDate(filtro: TransferenciaFiltro): Observable<Transferencia[]> {
    const url = `${this.baseUrl}/data/` + filtro;
    return this.http.get<Transferencia[]>(url);
  }
}
