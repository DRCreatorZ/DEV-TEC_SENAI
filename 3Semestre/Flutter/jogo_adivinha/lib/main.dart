import 'package:flutter/material.dart';
import 'dart:math';

void main() {
  runApp(AdivinhaApp());
}

class AdivinhaApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Adivinha(),
    );
  }
}

class Adivinha extends StatefulWidget {
  @override
  _AdivinhaState createState() => _AdivinhaState();
}

class _AdivinhaState extends State<Adivinha> {
  TextEditingController _palpite = TextEditingController();
  int numeroSort = Random().nextInt(100) + 1;
  String _resultado = '';
  int _tentativas = 0;

  void _verificar() {
    int palpite = int.tryParse(_palpite.text) ?? 0;
    setState(() {
      _tentativas++;
      if (palpite == numeroSort) {
        _resultado = 'Você Acertou!';
      } else if (palpite < numeroSort) {
        _resultado = 'Tente um Número Maior!';
      } else if (palpite > numeroSort) {
        _resultado = 'Tente um Número Menor!';
      } else {
        _resultado = 'Operação Incorreta!!!';
      }
    });
  }

  void _reiniciarJogo() {
    setState(() {
      numeroSort = Random().nextInt(100) + 1;
      _palpite.clear();
      _resultado = '';
      _tentativas = 0;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Jogo de Adivinha *1 a 100*'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller: _palpite,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(labelText: 'Palpite'),
            ),
            SizedBox(height: 10.0),
            ElevatedButton(
              onPressed: () => _verificar(),
              child: Text('Adivinhar'),
            ),
            SizedBox(height: 16.0),
            Text(
              _resultado,
              style: TextStyle(fontSize: 18.0, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 16.0),
            if (_resultado.isNotEmpty)
              ElevatedButton(
                onPressed: () => _reiniciarJogo(),
                child: Text('Jogar Novamente'),
              ),
            Text(
              'Tentativas: $_tentativas',
              style: TextStyle(fontSize: 18.0, fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
    );
  }
}
