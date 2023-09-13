<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "aluno";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    header("Location: erro.html");
    exit();
} else {
    $nome = $_POST['nome'];
    $endereco = $_POST['endereco'];
    $email = $_POST['email'];
    $sexo = $_POST['sexo'];
    $dataNac = $_POST['dataNasc'];
    $data = implode("-", array_reverse(explode("/", $dataNasc)));

    $sql = "INSERT INTO aluno (nome, endereco, email, sexo, dataNasc)
            VALUES ('$nome', '$endereco', '$email', '$sexo', '$dataNasc')";

    if ($conn->query($sql) === TRUE) {
        header("Location: sucesso.html");
        exit();
    } else {
        header("Location: erro.html");
        exit();
    }
}
$conn->close();
?>