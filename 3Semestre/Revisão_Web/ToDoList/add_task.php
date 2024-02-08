<?php

// Configurações do banco de dados PostgreSQL
$host = 'postgres';
$dbname = 'postgres';
$user = 'postgres';
$password = 'postgres';

// Conexão com o banco de dados
$conn = new PDO("pgsql:host=$host;dbname=$dbname", $user, $password);
$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

// Verifica se a tabela tasks já existe, se não, a cria
$stmt = $conn->query("SELECT EXISTS (
                          SELECT FROM information_schema.tables 
                          WHERE table_schema = 'public' 
                          AND table_name = 'tasks'
                       )");
$tableExists = $stmt->fetchColumn();
if (!$tableExists) {
    $conn->exec("CREATE TABLE tasks (
                    id SERIAL PRIMARY KEY,
                    description TEXT NOT NULL
                )");
}

// Verifica se o formulário foi enviado
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Obtém a tarefa do formulário
    $task = $_POST["task"];

    // Prepara a consulta SQL para inserir a tarefa no banco de dados
    $stmt = $conn->prepare("INSERT INTO tasks (description) VALUES (:task)");
    $stmt->bindParam(':task', $task);
    
    // Executa a consulta
    $stmt->execute();

    // Redireciona de volta para a página inicial
    header("Location: index.html");
    exit();
}
?>
