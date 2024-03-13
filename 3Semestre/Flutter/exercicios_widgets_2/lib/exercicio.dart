// ignore_for_file: prefer_const_constructors, sort_child_properties_last, prefer_final_fields, use_key_in_widget_constructors, library_private_types_in_public_api

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Exercicio 04 e 05',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int _selectedIndex = 0;

  static List<Widget> _widgetOptions = <Widget>[
    InicioPage(),
    ContactPage(),
    StorePage(),
    ConfiguracoesPage(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    // Verifica se a largura da tela é maior que um certo threshold para desktops
    bool isTablet = MediaQuery.of(context).size.width > 800;

    return Scaffold(
      appBar: AppBar(
        title: Text('Exercicio 04 e 05'),
      ),
      // Corpo do aplicativo varia de acordo com o item selecionado
      body: _widgetOptions.elementAt(_selectedIndex),
      // BottomNavigationBar somente para dispositivos móveis
      bottomNavigationBar: isTablet
          ? null
          : BottomNavigationBar(
              items: const <BottomNavigationBarItem>[
                BottomNavigationBarItem(
                  icon: Icon(Icons.home),
                  label: 'Início',
                ),
                BottomNavigationBarItem(
                  icon: Icon(Icons.contact_page),
                  label: 'Contato',
                ),
                BottomNavigationBarItem(
                  icon: Icon(Icons.store),
                  label: 'Loja',
                ),
                BottomNavigationBarItem(
                  icon: Icon(Icons.settings),
                  label: 'Configurações',
                ),
              ],
              currentIndex: _selectedIndex,
              unselectedItemColor: Colors.grey,
              selectedItemColor: Colors.blue,
              onTap: _onItemTapped,
            ),
      // Drawer para desktop
      drawer: isTablet
          ? Drawer(
              child: ListView(
                children: [
                  DrawerHeader(
                    child: Text("Menu"),
                    decoration: BoxDecoration(
                      color: Colors.blue,
                    ),
                  ),
                  ListTile(
                    leading: Icon(Icons.home),
                    title: Text("Início"),
                    onTap: () => _onItemTapped(0),
                  ),
                  ListTile(
                    leading: Icon(Icons.contact_page),
                    title: Text("Contato"),
                    onTap: () => _onItemTapped(1),
                  ),
                  ListTile(
                    leading: Icon(Icons.shop),
                    title: Text("Loja"),
                    onTap: () => _onItemTapped(2),
                  ),
                  ListTile(
                    leading: Icon(Icons.settings),
                    title: Text("Configurações"),
                    onTap: () => _onItemTapped(3),
                  ),
                ],
              ),
            )
          : null,
    );
  }
}

class InicioPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Icon(
            Icons.home,
            size: 100,
            color: Colors.red,
          ),
          SizedBox(height: 5),
          Image.asset('../lib/assets/senai.png', width: 150),
          SizedBox(height: 5),
          Text(
            'Página Início do exercício 04',
            style: TextStyle(fontSize: 30, color: Colors.black),
          ),
        ],
      ),
    );
  }
}

class ContactPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    MediaQueryData mediaQueryData = MediaQuery.of(context);
    double screenWidth = mediaQueryData.size.width;
    // Dynamic textSize based on screen width
    double textSize = screenWidth * 0.05;

    return Scaffold(
      appBar: AppBar(
        // Adjustments might be necessary based on your layout
        title: Text('Entre em contato'),
        titleTextStyle: TextStyle(
          color: Colors.black,
          fontSize: textSize,
        ),
      ),
      body: Center(
        child: Container(
          width: screenWidth * 0.8,
          padding: EdgeInsets.all(16.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextField(
                decoration: InputDecoration(
                  labelText: 'Nome',
                ),
              ),
              SizedBox(height: 20),
              TextField(
                decoration: InputDecoration(
                  labelText: 'E-mail',
                ),
              ),
              SizedBox(height: 20),
              TextField(
                decoration: InputDecoration(
                  labelText: 'Mensagem',
                ),
                maxLines: 4,
              ),
              SizedBox(height: 20),
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.blue,
                  textStyle: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                  ),
                ),
                onPressed: () {
                  // Lógica para enviar o formulário
                },
                child: const Text('Enviar'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class ConfiguracoesPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text(
        'Painel de Configurações',
        style: TextStyle(fontSize: 24),
      ),
    );
  }
}

class StorePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Painel de Configurações'),
      ),
      body: ListView(
        padding: EdgeInsets.all(16.0),
        children: [
          _buildProductCard(
            imageUrl: '../lib/assets/product.webp',
            title: 'Produto 1',
            description: 'Descrição do Produto 1',
          ),
          SizedBox(height: 16.0),
          _buildProductCard(
            imageUrl: '../lib/assets/product.webp',
            title: 'Produto 2',
            description: 'Descrição do Produto 2',
          ),
          SizedBox(height: 16.0),
          _buildProductCard(
            imageUrl: '../lib/assets/product.webp',
            title: 'Produto 3',
            description: 'Descrição do Produto 3',
          ),
        ],
      ),
    );
  }

  Widget _buildProductCard(
      {required String imageUrl,
      required String title,
      required String description}) {
    return Card(
      elevation: 4.0,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(10.0),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          ClipRRect(
            borderRadius: BorderRadius.vertical(top: Radius.circular(10.0)),
            child: Image.network(
              imageUrl,
              fit: BoxFit.cover,
              width: double.infinity,
              height: 150.0,
            ),
          ),
          Padding(
            padding: EdgeInsets.all(12.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  title,
                  maxLines: 1,
                  overflow: TextOverflow.ellipsis,
                  style: TextStyle(
                    fontSize: 18.0,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                SizedBox(height: 8.0),
                Text(
                  description,
                  style: TextStyle(
                    fontSize: 16.0,
                  ),
                ),
                SizedBox(height: 8.0),
                ButtonBar(
                  children: <Widget>[
                    TextButton(
                      child: Text(
                        'DETALHES',
                        style: TextStyle(
                          color: Colors.blue,
                          fontSize: 16.0,
                        ),
                      ),
                      onPressed: () {},
                    ),
                    TextButton(
                      child: Icon(
                        Icons.share,
                        size: 25,
                        color: Colors.blue,
                      ),
                      onPressed: () {},
                    ),
                  ],
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
