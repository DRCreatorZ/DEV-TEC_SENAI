import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'ListView com Cards',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  final List<String> items = List.generate(10, (index) => 'Item ${index + 1}');
  final List<String> subtitles = List.generate(10, (index) => 'Subtítulo ${index + 1}'); // Lista de subtítulos

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('ListView com Cards'),
      ),
      body: ListView.builder(
        itemCount: items.length,
        itemBuilder: (context, index) {
          return Card(
            child: ListTile(
              title: Text(items[index]),
              subtitle: Text(subtitles[index]), // Acessando o subtítulo correspondente ao índice
              leading: Icon(Icons.info),
              onTap: () {
                // Ação ao clicar no card
              },
            ),
          );
        },
      ),
    );
  }
}
