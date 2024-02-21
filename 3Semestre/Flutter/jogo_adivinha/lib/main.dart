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
  bool acertou = false;

  void _verificar() {
    int palpite = int.tryParse(_palpite.text) ?? 0;
    setState(() {
      _tentativas++;
      if (palpite == numeroSort) {
        _resultado = 'Você Acertou!';
        acertou = true;
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
      acertou = false;
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
            Text(
              'Tentativas: $_tentativas',
              style: TextStyle(fontSize: 18.0, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 16.0),
            if (acertou)
              ElevatedButton(
                onPressed: () => _reiniciarJogo(),
                child: Text('Jogar Novamente'),
              ),
          ],
        ),
      ),
    );
  }
}
