<?php

$imagem = $_FILES["imagem"]; // Recebe o arquivo enviado através do formulário

$host = "localhost";
$username = "root";
$password = "";
$db = "aula16";

if ($imagem != null && $imagem['error'] == 0) { 
    // Verifica se um arquivo foi enviado e se não houve erros no upload

    $nomeFinal = time() . '.jpg'; 
    // Cria um nome único para o arquivo usando o timestamp atual e a extensão .jpg

    if (move_uploaded_file($imagem['tmp_name'], $nomeFinal)) { 
        // Move o arquivo temporário para o destino final

        $conexao = mysqli_connect($host, $username, $password, $db); 
        // Conecta ao banco de dados usando mysqli (recomendado em vez de mysql, que está obsoleto)

        if (!$conexao) {
            die("Impossível Conectar: " . mysqli_connect_error());
            // Se a conexão falhar, encerra o script e exibe uma mensagem de erro
        }

        $tamanhoImg = filesize($nomeFinal);
        $mysqlImg = addslashes(file_get_contents($nomeFinal)); 
        // Lê o arquivo em binário e adiciona barras invertidas antes de caracteres especiais

        $query = "INSERT INTO AULA16 (AULA16_IMG) VALUES ('$mysqlImg')";
        // Monta uma query SQL para inserir a imagem no banco de dados

        if (mysqli_query($conexao, $query)) {
            unlink($nomeFinal); 
            // Remove o arquivo temporário após o upload bem-sucedido
            header("location: exibir.php"); 
            // Redireciona o usuário para a página 'exibir.php'
        } else {
            echo "O sistema não foi capaz de executar a query: " . mysqli_error($conexao);
            // Se a query falhar, exibe uma mensagem de erro
        }

        mysqli_close($conexao); 
        // Fecha a conexão com o banco de dados
    } else {
        echo "Falha ao mover o arquivo para o destino final.";
        // Se a operação de mover o arquivo falhar, exibe uma mensagem de erro
    }
} else {
    echo "Você não realizou o upload de forma satisfatória.";
    // Se não houve upload ou ocorreu um erro no upload, exibe uma mensagem de erro
}

?>
