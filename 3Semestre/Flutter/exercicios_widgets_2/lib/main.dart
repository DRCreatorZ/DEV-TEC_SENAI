// ignore_for_file: prefer_const_constructors, avoid_web_libraries_in_flutter

import 'dart:js';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Tabela de Informações'),
        ),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            _buildTableRow(Icons.person, 'Nome', 'João'),
            _buildTableRow(Icons.calendar_today, 'Idade', '30 anos'),
            _buildTableRow(Icons.location_on, 'Endereço', 'Rua Exemplo, 123'),
            _buildTableRow(Icons.email, 'Email', 'joao@example.com'),
          ],
        ),
      ),
    );
  }

  Widget _buildTableRow(IconData icon, String title, String value) {
    return GestureDetector(
      onTap: () {
        final snackBar = SnackBar(content: Text('Mais informações: $title - $value'));
        ScaffoldMessenger.of(context as BuildContext).showSnackBar(snackBar);
      },
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Row(
          children: [
            Icon(icon),
            SizedBox(width: 10),
            Text(
              '$title: $value',
              style: TextStyle(fontSize: 18),
            ),
          ],
        ),
      ),
    );
  }
}
