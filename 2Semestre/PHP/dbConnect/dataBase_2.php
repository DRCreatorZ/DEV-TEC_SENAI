<?php

// Dados de conexão com o banco de dados
$servername = "localhost";
$username = "username";
$password = "";
$database = "drc_banco";

//Criar a conexão
$conn = mysqli_connect($servername, $username, $password, $database);
//Verificando a conexão
if(!$conn){

die("Falha na conexão!." . mysqli_connect_error());

}

echo "Conectado com sucesso!";
mysqli_close($conn);

?>