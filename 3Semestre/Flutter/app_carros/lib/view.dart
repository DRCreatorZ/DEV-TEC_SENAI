// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, prefer_const_constructors_in_immutables

import 'package:flutter/material.dart';
import 'package:app_carros/model.dart';
import 'package:app_carros/controller.dart';
import 'package:provider/provider.dart';

class TelaListaCarros extends StatelessWidget {
  final CarrosController controllerCarros;
  TelaListaCarros (this.controllerCarros);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra superior do aplicativo
      appBar: AppBar(
        title: Text('Lista de Carros'),
      ),
      // Corpo principal do aplicativo
      body: Column(
        children: [
          // Lista de carros usando um Consumer do Provider para atualização automática
         Expanded(
             child:// Consumer<CarrosController>(
            //   builder: (context, model, child) {
               // return 
                ListView.builder(
                  itemCount: controllerCarros.listarCarros.length,
                  itemBuilder: (context, index) {
                    return ListTile(
                      // Exibição dos carros listados no Controller
                      title: Text(controllerCarros.listarCarros[index].modelo),
                      // Quando clicado, muda de tela para Descriçao do carro
                      onTap: () {
                        // Chamando o método pra troca de tela
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) =>
                                TelaDetalheCarro(controllerCarros.listarCarros[index]),
                          ),
                        );
                      },
                    );
                  },
                ),
            //   },
            // ),
          ),
        ],
      ),
    );
  }
}

class TelaDetalheCarro extends StatelessWidget {
  final Carro carro;
  TelaDetalheCarro(this.carro);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Detalhes do Carro"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Image.network(carro.imagemUrl),
            SizedBox(height: 20),
            Text("Modelo: ${carro.modelo}"),
            Text("Ano: ${carro.ano}"),
          ],
        ),
      ),
    );
  }
}
