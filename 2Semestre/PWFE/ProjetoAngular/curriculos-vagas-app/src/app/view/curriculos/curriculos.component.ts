import { Component, OnInit } from '@angular/core';
import { Curriculo } from 'src/app/model/curriculo.model';
import { Vaga } from 'src/app/model/vaga.model';
import { VagaService } from 'src/app/service/vagas.service';

@Component({
  selector: 'app-curriculos',
  templateUrl: './curriculos.component.html',
  styleUrls: ['./curriculos.component.css']
})
export class CurriculosComponent implements OnInit {
  public curriculo: Curriculo = new Curriculo(0, '', '', '', 0);
  // Uma instância de 'Vaga' para rastrear os dados do formulário
  public curriculos: Curriculo[] = [];
  // Uma matriz para armazenar as vagas listadas
  constructor(private _curriculosService: CurriculoService) {}
  // aplica o serviço 'VagaService' no construtor
  ngOnInit(): void {
    this.listarCurriculos();
    // Quando o componente é inicializado, lista as vagas disponíveis
  }
  listarCurriculos() {
    // Lista as vagas do servidor usando o serviço 'VagaService'
    this._curriculossService.getCurriculos().subscribe((retornaCurriculo) => {
      this.curriculos = retornaCurriculo.map((item) => {
        // Mapeia os dados retornados para objetos 'Vaga'
        return new Curriculo(
          item.id,
          item.nome,
          item.sobrenome,
          item.email,
          item.salario
        );
      });
    });
  }
  listarVaga(vaga: Vaga) {
    // Função para listar uma vaga individual no formulário para edição
    this.vaga = vaga;
    // A vaga clicada é definida como a vaga atual no formulário
  }
  cadastrar() {
    // Função para cadastrar uma nova vaga
    this._vagasService.cadastrarVaga(this.vaga).subscribe(
      () => {
        // Após cadastrar com sucesso
        this.vaga = new Vaga(0, '', '', '', 0); // Limpa o formulário
        this.listarVagas(); // Atualiza a lista de vagas
      },
      (err) => {
        console.log('Erro ao cadastrar', err);
        // Em caso de erro, exibe uma mensagem no console
      }
    );
  }
  atualizar(id: number) {
    // Função para atualizar uma vaga existente
    this._vagasService.atualizarVaga(id, this.vaga).subscribe(
      () => {
        // Após atualizar com sucesso
        this.vaga = new Vaga(0, '', '', '', 0); // Limpa o formulário
        this.listarVagas(); // Atualiza a lista de vagas
      },
      (err) => {
        console.log('Erro ao atualizar', err);
      }
    );
  }
  excluir(id: number) {
    // Função para excluir uma vaga
    this._vagasService.removerVaga(id).subscribe(
      () => {
        // Após excluir com sucesso
        this.vaga = new Vaga(0, '', '', '', 0); // Limpa o formulário

        this.listarVagas(); // Atualiza a lista de vagas
      },
      (err) => {
        console.log('Erro ao excluir', err);
      }
    );
  }
}
