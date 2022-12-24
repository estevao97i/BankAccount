import { AfterViewInit, Component, ViewChild, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Transferencia } from 'src/model/transferencia-model';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import { TransferenciaService } from '../service/transferencia.service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { TransferenciaFiltro } from '../../model/transferencia-filtro-model';


@Component({
  selector: 'app-tabela-transferencia',
  templateUrl: './tabela-transferencia.component.html',
  styleUrls: ['./tabela-transferencia.component.css']
})
export class TabelaTransferenciaComponent implements AfterViewInit, OnInit {

  listaTransferencias: Transferencia[] = new Array<Transferencia>();
  formBuilder: FormBuilder = new FormBuilder();
  form = this.buildForm();

  displayedColumns: string[] = ['dataTranferencia', 'valor', 'tipo', 'nomeOperadorTransacao'];
  dataSource: MatTableDataSource<Transferencia>;
  list: Transferencia[] = new Array<Transferencia>();

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  // @ViewChild(MatSort) sort: MatSort | undefined;

  constructor (private service: TransferenciaService,
    ) {
      const users = new Array<Transferencia>();
      this.dataSource = new MatTableDataSource(users);
    }

    ngAfterViewInit() {
      // this.dataSource.paginator = this.paginator;
      // this.dataSource.sort = this.sort;
    }

    ngOnInit(): void {
      this.buildForm();
      this.list = [
        { dataTranferencia: '2020-03-03', valor: '400', tipo: 'Deposito', nomeOperadorTransacao: 'estevao' },
        { dataTranferencia: '2020-03-03', valor: '400', tipo: 'Deposito', nomeOperadorTransacao: 'estevao' },
        { dataTranferencia: '2020-03-03', valor: '400', tipo: 'Deposito', nomeOperadorTransacao: 'estevao' },
        { dataTranferencia: '2020-03-03', valor: '400', tipo: 'Deposito', nomeOperadorTransacao: 'estevao' },
        { dataTranferencia: '2020-03-03', valor: '400', tipo: 'Deposito', nomeOperadorTransacao: 'estevao' },
        { dataTranferencia: '2020-03-03', valor: '400', tipo: 'Deposito', nomeOperadorTransacao: 'estevao' },
      ]
      // this.findAll();
    }

    findAll() {
      this.listaTransferencias = new Array<Transferencia>();
      this.service.findAll().subscribe((data) => {
        this.listaTransferencias = data;
      })
    }

    buildForm() {
      return this.formBuilder.group({
        dataInicio: '',
        dataFim: '',
        nomeOperadorTransacao: ''
      })
    }

  applyFilter() {
    this.listaTransferencias = new Array<Transferencia>();
    let filtro = new TransferenciaFiltro();
    filtro.dataInic = this.form.get('dataInic')?.value ? this.form.get('dataInic')?.value : null;
    filtro.dataFim = this.form.get('dataFim')?.value ? this.form.get('dataFim')?.value : null;
    filtro.nomeOperadorTransacao = this.form.get('nomeOperadorTransacao')?.value ? this.form.get('nomeOperadorTransacao')?.value : null;

    if (filtro.dataInic && filtro.dataFim && filtro.nomeOperadorTransacao) {

    } else
    if (filtro.dataInic || filtro.dataFim) {
      this.service.findByDate(filtro).subscribe((data) => {
        this.listaTransferencias = data;
      })
    } else
    if (this.form.get('nomeOperadorTransacao')?.value) {

    }
  }
}
