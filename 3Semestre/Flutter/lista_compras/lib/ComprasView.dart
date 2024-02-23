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
        title: Text('Lista de Compras'),
      ),
      // Corpo principal do aplicativo
      body: Column(
        children: [
          // Campo de texto para adicionar nova compra
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _controller,
              decoration: InputDecoration(
                labelText: 'Nova Tarefa',
                // Ícone para adicionar compra ao pressionar o botão
                suffixIcon: IconButton(
                  onPressed: () {
                    // Chamando o método adicionarTarefa do Provider para atualizar o estado
                    Provider.of<ComprasController>(context, listen: false)
                        .adicionarTarefa(_controller.text);
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
                              model.marcarComoConcluida(
                                  index); // Marca como concluída se o valor for true
                            } else {
                              model.desmarcarComoConcluida(
                                  index); // Desmarca se o valor for false
                            }
                          }
                        },
                      ),
                      // Exclui a compra ao manter pressionado
                      onLongPress: () {
                        // Chamando o método excluirTarefa do Provider para atualizar o estado
                        model.excluirTarefa(index);
                      },
                    );
                  },
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
