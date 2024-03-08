import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Menu de Opções'),
        // Adicionando um botão de menu na barra de aplicativo
        actions: [
          Builder(
            builder: (context) => IconButton(
              icon: Icon(Icons.menu),
              onPressed: () {
                // Abre o menu lateral (Drawer) quando o botão de menu é pressionado
                Scaffold.of(context).openDrawer();
              },
            ),
          ),
        ],
      ),
      // Adicionando o Drawer
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            DrawerHeader(
              decoration: BoxDecoration(
                color: Colors.blue,
              ),
              child: Text(
                'Opções do Menu',
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 24,
                ),
              ),
            ),
            ListTile(
              title: Text('Opção 1'),
              onTap: () {
                // Adicione a lógica para lidar com a opção 1
                Navigator.pop(context);
              },
            ),
            ListTile(
              title: Text('Opção 2'),
              onTap: () {
                // Adicione a lógica para lidar com a opção 2
                Navigator.pop(context);
              },
            ),
            ListTile(
              title: Text('Opção 3'),
              onTap: () {
                // Adicione a lógica para lidar com a opção 3
                Navigator.pop(context);
              },
            ),
          ],
        ),
      ),
      body: Center(
        child: Text('Conteúdo da Página'),
      ),
    );
  }
}
