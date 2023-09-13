<?php
// Conexão com o banco de dados
$host = 'localhost';
$usuario = 'root';
$senha = '';
$banco = 'aluno';
// Cria uma conexao com o banco de dados
$conn = mysqli($host, $usuario, $senha, $banco);
//Verifica se a conexao foi bem sucedida
if ($conn->connect_error) {
    // Redireciona para uma pagina de erro
        header('Location: erro.php');
        exit();
} else {
    //Recupera os dados do formulario
    $nome = $_POST['nome'];
    $endereco = $_POST['endereco'];
    $email = $_POST['email'];
    $sexo = $_POST['sexo'];
    $dataNasc = $_POST['dataNasc'];
    //data em formato br para inserir no mysql
    $data = implode("-", array_reverse(explode("/", $dataNasc)));
    // Insere os dados na tabela do banco
    $sql = "INSERT INTO aluno (nome,endereco, sexo, email,dataNasc) VALUES ('$nome','$endereco', $email', '$sexo', $dataNasc')";
    if ($conn->query($sql) === TRUE) {
         //redireciona para uma pagina de sucesso
        header('Location: sucesso.php');
        exit();
    } else {
        // Redireciona para uma pagina de erro
        header('Location: erro.php');
        exit();
    } else {
    // Redireciona para uma pagina de erro
    header('Location: erro.php');
        exit();
    }
}
$conn->close();
?>