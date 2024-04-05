class UserModel {
    // atributos
    int id;
    String username;
    String password;

    // construtor
    UserModel({
    required this.id,
    required this.username,
    required this.password,
    });

    // mapeamento
    Map<String, dynamic> toMap() {
    return {
        'id': id,
        'username': username,
        'password': password,
    };
    }

    factory UserModel.fromMap(Map<String, dynamic> map) {
    return UserModel(
        id: map['id'],
        username: map['username'],
        password: map['password'],
    );
    }
}