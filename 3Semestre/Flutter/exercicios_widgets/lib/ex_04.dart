import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;

  static const List<Widget> _widgetOptions = <Widget>[
    Home(),
    Business(),
    School(),
  ];

  // static const List<Widget> _widgetOptionsWithImages = <Widget>[
  //   Image(image: AssetImage('../lib/assets/home.png')),
  //   Image(image: AssetImage('../lib/assets/business.png')),
  //   Image(image: AssetImage('../lib/assets/school.png')),
  // ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Barra de Navegação Personalizada'),
      ),
      body: Center(
        child: _widgetOptions.elementAt(_selectedIndex),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.business),
            label: 'Business',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.school),
            label: 'School',
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.amber[800],
        onTap: _onItemTapped,
      ),
    );
  }
}

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Icon(
            Icons.home,
            size: 100,
            color: Color.fromARGB(255, 182, 83, 34),
          ),
          SizedBox(height: 5),
          Image.asset('../lib/assets/home.png', width: 150),
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
class Business extends StatelessWidget {
  const Business({super.key});
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Icon(
            Icons.business,
            size: 100,
            color: Color.fromARGB(255, 141, 22, 143),
          ),
          SizedBox(height: 5),
          Image.asset('../lib/assets/business.png', width: 150),
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
class School extends StatelessWidget {
  const School({super.key});
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Icon(
            Icons.school,
            size: 100,
            color: Color.fromARGB(255, 9, 145, 120),
          ),
          SizedBox(height: 5),
          Image.asset('../lib/assets/school.png', width: 150),
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