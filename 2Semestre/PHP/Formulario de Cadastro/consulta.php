<?php
//$servername = "nome_do_servidor";
//$username = "nome_de_usuario";
//$password = "senha";
//$dbname = "nome_do_banco_de_dados";

$conexao = mysqli_connect('localhost', 'root', '');
$banco = mysqli_select_db($conexao, 'aluno');
mysqli_set_charset($conexao, 'utf8');

$sql = mysqli_query($conexao, "select * from aluno") or die("Erro.");
while($dados = mysqli_fetch_assoc($sql)) {
    echo $dados['id'] . ' ';
    echo $dados['nome'] . '<br>';
}
?>