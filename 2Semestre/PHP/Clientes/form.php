<?php
// Conexão com o banco de dados
$host = 'localhost';
$usuario = 'root';
$senha = '';
$banco = 'clientes';
// Cria uma conexao com o banco de dados
$conexao = mysqli_connect($host, $usuario, $senha, $banco);
//Verifica se a conexao foi bem sucedida
if ($conexao) {
    //Recupera os dados do formulario
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $dataNasc = $_POST['dataNasc'];
    $endereco = $_POST['endereco'];
    $data = implode("-", array_reverse(explode("/", $dataNasc)));

    // Insere os dados na tabela do banco
    $sql = "INSERT INTO clientes (nome,email,dataNasc,endereco) VALUES ('$nome','$email','$dataNasc','$endereco')";
    mysqli_query($conexao, $sql);

    // Verifica se a inserção foi bem sucedida
    if (mysqli_affected_rows($conexao) > 0) {
        //redireciona para uma pagina de sucesso
        header('Location: sucesso.php');
    } else {
        // Redireciona para uma pagina de erro
        header('Location: erro.php');
    }
} else {
    // Redireciona para uma pagina de erro
    header('Location: erro.php');
}