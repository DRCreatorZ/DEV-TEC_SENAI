<?php
// endereco
// nome do BD
// usuario
// senha
$endereco = 'localhost';
$banco = 'DBnoite';
$admin = 'postgres';
$senha = 'postgres';
try {
    // sgbd:host;port;dbname
    // usuario
    // senha
    // errmode
    $pdo = new PDO(
        "pgsql:host=$endereco;port=5432;dbname=$banco",
        $admin,
        $senha,
        [PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION]
    );
    echo "Conectado no banco de dados!!!";
    $sql = "CREATE TABLE IF NOT EXISTS usuarios (nome VARCHAR(255), data_nascimento VARCHAR(255), telefone VARCHAR(255), email VARCHAR(255) PRIMARY KEY, senha VARCHAR(255))";
    $stmt = $pdo->prepare($sql);
    $stmt->execute();
} catch (PDOException $e) {
    echo "Falha ao conectar ao banco de dados. <br/>";
    die($e->getMessage());
}
