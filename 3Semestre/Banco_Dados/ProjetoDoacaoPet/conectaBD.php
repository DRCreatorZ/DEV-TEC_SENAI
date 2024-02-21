<?php
// Configurações de conexão com o banco de dados
$endereco = 'localhost'; // Endereço do banco de dados
$banco = 'postgres'; // Nome do banco de dados
$usuario = 'postgres'; // Nome de usuário do banco de dados
$senha = 'postgres'; // Senha do banco de dados

try {
    // Estabelece a conexão com o banco de dados usando PDO
    $pdo = new PDO(
        "pgsql:host=$endereco;port=5432;dbname=$banco",
        $usuario,
        $senha,
        [PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION]
    );

    // Verifica se o banco de dados existe
    $stmt = $pdo->query("SELECT 1 FROM pg_database WHERE datname='$banco'");
    if (!$stmt->fetch(PDO::FETCH_ASSOC)) {
        // Se o banco de dados não existe, cria-o
        $pdo->query("CREATE DATABASE $banco");
        echo "Banco de dados criado com sucesso!";
    } else {
        error_log("Banco de dados já existe!");    }

    // Não é necessário selecionar o banco de dados explicitamente no PostgreSQL

    // Cria a tabela 'usuario' se não existir
    $stmt = $pdo->query("SELECT 1 FROM information_schema.tables WHERE table_name = 'usuario'");
    if (!$stmt->fetch(PDO::FETCH_ASSOC)) {
        $pdo->query("
            CREATE TABLE usuario (
                id SERIAL PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                data_nascimento DATE NOT NULL,
                telefone VARCHAR(20) NOT NULL,
                email VARCHAR(100) NOT NULL,
                senha VARCHAR(255) NOT NULL
            )
        ");
        echo "Tabela 'usuario' criada com sucesso!";
    } else {
        error_log("Tabela 'usuario' já existe!");
    }

} catch (PDOException $e) {
    // Captura e trata erros de conexão
    echo "Falha ao conectar ao banco de dados. <br/>";
    // Exibe a mensagem de erro específica
    die($e->getMessage());
}
?>
