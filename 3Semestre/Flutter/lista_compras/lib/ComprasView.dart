import 'package:flutter/material.dart';
import 'package:lista_compras/ComprasController.dart';
import 'package:provider/provider.dart';

class ComprasScreen extends StatelessWidget {
  // Controlador para o campo de texto de nova compra
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra superior do aplicativo
      appBar: AppBar(
        title: Row(
          children: [
            // Ícone de carrinho de compras
            Icon(Icons.shopping_cart ,color: Colors.grey[800]),
            SizedBox(width: 8), // Espaçamento entre o ícone e o texto
            Text(
              'Lista de Compras',
              style: TextStyle(
                color: Colors.grey[800], // Cor do texto cinza escuro
              ),
            ),
          ],
        ),
        backgroundColor: Colors.deepOrange[700], // Cor de fundo laranja escuro
      ),
      // Corpo principal do aplicativo
      body: Column(
        children: [
          // Campo de texto para adicionar novo Item com "Enter"
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _controller,
              onSubmitted: (value) {
                // Chamando o método adicionar Item do Provider para atualizar o estado
                Provider.of<ComprasController>(context, listen: false).adicionarItem(value);
                // Limpar o campo de texto após adicionar a compra
                _controller.clear();
              },
              decoration: InputDecoration(
                labelText: 'Novo Item',
                // Ícone para adicionar compra ao pressionar o botão
                suffixIcon: IconButton(
                  onPressed: () {
                    // Chamando o método adicionar Item do Provider para atualizar o estado
                    Provider.of<ComprasController>(context, listen: false).adicionarItem(_controller.text);
                    // Limpar o campo de texto após adicionar a compra
                    _controller.clear();
                  },
                  icon: Icon(Icons.add),
                ),
              ),
            ),
          ),
          // Lista de compras usando um Consumer do Provider para atualização automática
          Expanded(
            child: Consumer<ComprasController>(
              builder: (context, model, child) {
                return ListView.builder(
                  itemCount: model.compras.length,
                  itemBuilder: (context, index) {
                    return ListTile(
                      // Exibição do texto da compra
                      title: Text(model.compras[index].descricao),
                      // Checkbox para marcar a compra como concluída
                      trailing: Checkbox(
                        value: model.compras[index].concluida,
                        onChanged: (value) {
                          if (value != null) {
                            if (value) {
                              model.marcarComoComprado(
                                  index); // Marca como concluída se o valor for true
                            } else {
                              model.desmarcarComoComprado(
                                  index); // Desmarca se o valor for false
                            }
                          }
                        },
                      ),
                      // Exclui a compra ao manter pressionado
                      onLongPress: () {
                        // Exibe o diálogo de confirmação antes de excluir
                        showDialog(
                          context: context,
                          builder: (context) => AlertDialog(
                            title: Text('Confirmar exclusão'),
                            content: Text(
                                'Deseja realmente excluir o item "${model.compras[index].descricao}"?'),
                            actions: <Widget>[
                              TextButton(
                                onPressed: () {
                                  Navigator.of(context).pop(); // Fecha o diálogo
                                },
                                child: Text('Cancelar'),
                              ),
                              TextButton(
                                onPressed: () {
                                  // Chamando o método excluirItem do Provider para atualizar o estado
                                      model.excluirItem(index);
                                  Navigator.of(context).pop(); // Fecha o diálogo
                                },
                                child: Text('Excluir'),
                              ),
                            ],
                          ),
                        );
                      },
                    );
                  },
                );
              },
            ),
          ),
        ],
      ),
      bottomNavigationBar: BottomAppBar(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            // Botão na barra de aplicativos para excluir todos os itens
            IconButton(
              icon: Icon(Icons.delete),
              onPressed: () {
                // Exibe um AlertDialog para confirmação antes de excluir todos os itens
                showDialog(
                  context: context,
                  builder: (context) => AlertDialog(
                    title: Text('Confirmar exclusão'),
                    content: Text('Deseja realmente excluir todos os itens da lista de compras?'),
                    actions: <Widget>[
                      TextButton(
                        onPressed: () {
                          Navigator.of(context).pop(); // Fecha o diálogo
                        },
                        child: Text('Cancelar'),
                      ),
                      TextButton(
                        onPressed: () {
                          // Chamando o método excluirTodosItens do Provider para atualizar o estado
                          Provider.of<ComprasController>(context, listen: false).excluirTodosItens();
                          Navigator.of(context).pop(); // Fecha o diálogo
                        },
                        child: Text('Excluir'),
                      ),
                    ],
                  ),
                );
              },
            ),
            // Botão na barra de aplicativos para ordenar por ordem alfabética
            IconButton(
              icon: Icon(Icons.sort_by_alpha),
              onPressed: () {
                // Chamando o método ordenarListaPorNome do Provider para ordenar a lista alfabeticamente
                Provider.of<ComprasController>(context, listen: false).ordemAZ();
              },
            ),
          ],
        ),
        color: Colors.deepOrange[700], // Cor de fundo laranja escuro
      ),
    );
  }
}
