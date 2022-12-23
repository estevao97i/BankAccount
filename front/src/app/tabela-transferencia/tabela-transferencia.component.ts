import { AfterViewInit, Component, ViewChild, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Transferencia } from 'src/model/transferencia-model';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import { TransferenciaService } from '../service/transferencia.service';


@Component({
  selector: 'app-tabela-transferencia',
  templateUrl: './tabela-transferencia.component.html',
  styleUrls: ['./tabela-transferencia.component.css']
})
export class TabelaTransferenciaComponent implements AfterViewInit, OnInit {

  listaTransferencias: Transferencia[] = new Array<Transferencia>();

  displayedColumns: string[] = ['dataTranferencia', 'valor', 'tipo', 'nomeOperadorTransacao'];
  dataSource: MatTableDataSource<Transferencia>;

  // @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  // @ViewChild(MatSort) sort: MatSort | undefined;

  constructor (private service: TransferenciaService) {

    const users = new Array<Transferencia>();
    this.dataSource = new MatTableDataSource(users);
  }

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
    // this.dataSource.sort = this.sort;
  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.service.findAll().subscribe((data) => {
      this.listaTransferencias = data;
    })
  }
}
