import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget {
    const LoginPage({Key? key}) : super(key: key);

    @override
    State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
    final _formKey = GlobalKey<FormState>();
    final _usernameController = TextEditingController();
    final _passwordController = TextEditingController();

    @override
    Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
        title: const Text('Login'),
        ),
        body: Form(
        key: _formKey,
        child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
                TextFormField(
                controller: _usernameController,
                decoration: const InputDecoration(labelText: 'Usuário'),
                validator: (value) {
                    if (value == null || value.isEmpty) {
                    return 'Usuário obrigatório';
                    }
                    return null;
                },
                ),
                TextFormField(
                controller: _passwordController,
                obscureText: true,
                decoration: const InputDecoration(labelText: 'Senha'),
                validator: (value) {
                    if (value == null || value.isEmpty) {
                    return 'Senha obrigatória';
                    }
                    return null;
                },
                ),
                const SizedBox(height: 16.0),
                Row(
                mainAxisAlignment: MainAxisAlignment.end,
                children: [
                    ElevatedButton(
                    onPressed: () {
                        if (_formKey.currentState!.validate()) {
                        // Validar login
                        // ...

                        // Abrir tela de cadastro
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                            builder: (context) => const RegisterPage(),
                            ),
                        );
                        }
                    },
                    child: const Text('Cadastrar'),
                    ),
                    const SizedBox(width: 16.0),
                    ElevatedButton(
                    onPressed: () {
                        if (_formKey.currentState!.validate()) {
                        // Validar login
                        // ...

                        // Abrir tela principal
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                            builder: (context) => const HomePage(),
                            ),
                        );
                        }
                    },
                    child: const Text('Logar'),
                    ),
                ],
                ),
            ],
            ),
        ),
        ),
    );
    }
}

class RegisterPage extends StatelessWidget {
    const RegisterPage({Key? key}) : super(key: key);

    @override
    Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
        title: const Text('Cadastro'),
        ),
        body: const Center(
        child: Text('Página de cadastro'),
        ),
    );
    }
}

class HomePage extends StatelessWidget {
    const HomePage({Key? key}) : super(key: key);

    @override
    Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
        title: const Text('Início'),
        ),
        body: const Center(
        child: Text('Página inicial'),
        ),
    );
    }
}