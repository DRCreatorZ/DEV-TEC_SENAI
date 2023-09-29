<?php

$imagem = $_FILES["imagem"];
$host = "localhost";
$username = "root";
$password = "";
$db = "aula16";

if ($imagem != null && $imagem['error'] == 0) { // Verifica se um arquivo foi enviado e se não houve erros no upload
    $nomeFinal = time() . '.jpg';
    if (move_uploaded_file($imagem['tmp_name'], $nomeFinal)) { // Move o arquivo temporário para o destino final
        $conexao = mysqli_connect($host, $username, $password, $db); // Usando mysqli ao invés de mysql (obsoleto)
        if (!$conexao) {
            die("Impossível Conectar: " . mysqli_connect_error());
        }

        $tamanhoImg = filesize($nomeFinal);
        $mysqlImg = addslashes(file_get_contents($nomeFinal)); // Lê o arquivo em binário

        $query = "INSERT INTO AULA16 (AULA16_IMG) VALUES ('$mysqlImg')";
        if (mysqli_query($conexao, $query)) {
            unlink($nomeFinal); // Remove o arquivo temporário após o upload
            header("location: exibir.php");
        } else {
            echo "O sistema não foi capaz de executar a query: " . mysqli_error($conexao);
        }

        mysqli_close($conexao); // Fecha a conexão com o banco de dados
    } else {
        echo "Falha ao mover o arquivo para o destino final.";
    }
} else {
    echo "Você não realizou o upload de forma satisfatória.";
}

?>
