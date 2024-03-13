import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: ContactForm(),
    );
  }
}

class ContactForm extends StatefulWidget {
  @override
  _ContactFormState createState() => _ContactFormState();
}

class _ContactFormState extends State<ContactForm> {
  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _messageController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Formulário de Contato'),
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller: _nameController,
              decoration: InputDecoration(
                labelText: 'Nome',
              ),
            ),
            SizedBox(height: 16.0),
            TextField(
              controller: _emailController,
              decoration: const InputDecoration(
                labelText: 'E-mail',
              ),
            ),
            const SizedBox(height: 16.0),
            TextField(
              controller: _messageController,
              decoration: const InputDecoration(
                labelText: 'Mensagem',
              ),
              maxLines: 3,
            ),
            const SizedBox(height: 16.0),
            ElevatedButton(
              onPressed: () {
                _submitForm();
              },
              child: const Text('Enviar'),
            ),
          ],
        ),
      ),
    );
  }

  void _submitForm() {
    String name = _nameController.text;
    String email = _emailController.text;
    String message = _messageController.text;

    // Aqui você pode adicionar a lógica para enviar o formulário
    print('Nome: $name\nE-mail: $email\nMensagem: $message');

    // Limpa os campos após enviar o formulário
    _nameController.clear();
    _emailController.clear();
    _messageController.clear();
  }
}
