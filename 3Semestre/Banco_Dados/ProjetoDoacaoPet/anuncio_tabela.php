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

    // Cria a tabela 'anuncio' se não existir
    $stmt = $pdo->query("SELECT 1 FROM information_schema.tables WHERE table_name = 'anuncio'");
    if (!$stmt->fetch(PDO::FETCH_ASSOC)) {
        $pdo->query("
            CREATE TABLE anuncio (
                id SERIAL PRIMARY KEY,
                fase VARCHAR(1) NOT NULL,
                tipo VARCHAR(1) NOT NULL,
                porte VARCHAR(1) NOT NULL,
                pelagem_cor VARCHAR(255),
                raca VARCHAR(100),
                sexo VARCHAR(1) NOT NULL,
                observacao TEXT,
                email_usuario VARCHAR(100) NOT NULL
            )
        ");
        error_log("Tabela 'anuncio' criada com sucesso!");
    } else {
        error_log("Tabela 'anuncio' já existe!");
    }

} catch (PDOException $e) {
    // Captura e trata erros de conexão
    echo "Falha ao conectar ao banco de dados. <br/>";
    // Exibe a mensagem de erro específica
    die($e->getMessage());
}