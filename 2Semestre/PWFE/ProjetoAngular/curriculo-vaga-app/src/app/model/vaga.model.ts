export class Vaga {
    id: number=0;
    cargo: string='';
    descricao: string='';
    requisitos: string='';
    empresa: string='';
    localizacao: string='';
    salario: number=0;
    constructor(
    id: number,
    cargo: string,
    descricao: string,
    requisitos: string,
    empresa: string,
    localizacao: string,
    salario: number
    ) {
    this.id = id;
    this.cargo = cargo;
    this.descricao = descricao;
    this.requisitos = requisitos;
    this.empresa = empresa;
    this.localizacao = localizacao;
    this.salario = salario;
    }
    }