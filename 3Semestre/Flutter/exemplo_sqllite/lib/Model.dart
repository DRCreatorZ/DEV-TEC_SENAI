class ContatoModel {
  //atributos
   int id;
   String nome;
   String email;
   String telefone;
   String endereco;
  //construtor
  ContatoModel({
    required this.id,
    required this.nome,
    required this.email,
    required this.telefone,
    required this.endereco,
  });
  //mapeamento

  Map<String, dynamic> ToMap() => {
    "id": id,
    "nome": nome,
    "email": email,
    "telefone": telefone,
    "endereco": endereco,
  };
 
}

