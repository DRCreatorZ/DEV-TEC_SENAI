export class Curriculo {
  //atributos
id: number=0;
nome: string='';
sobrenome: string='';
email: string= '';
telefone: string='';
endereco: string='';
formacaoAcademica: string='';
experienciaProfissional: string='';
habilidades: string='';
idiomas: string='';
certificacoes: string='';

constructor(
id: number,
nome: string,
sobrenome: string,
email: string,
telefone: string,
endereco: string,
formacaoAcademica: string,
experienciaProfissional: string,
habilidades: string,
idiomas: string,
certificacoes: string
) {
this.id = id;
this.nome = nome;
this.sobrenome = sobrenome;
this.email = email;
this.telefone = telefone;
this.endereco = endereco;
this.formacaoAcademica = formacaoAcademica;
this.experienciaProfissional = experienciaProfissional;
this.habilidades = habilidades;
this.idiomas = idiomas;
this.certificacoes = certificacoes;
}
}
