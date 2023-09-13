<?php

include_once("mysqli_connect_error.php");

//Verificando a conexão
if(!$conn){

die("Falha na conexão!." . mysqli_connect_error());

}

echo "Conectado com sucesso!";
mysqli_close($conn);

