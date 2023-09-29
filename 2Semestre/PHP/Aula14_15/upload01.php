<?php

// Pasta onde quer salvar os arquivos (obs.: permissões de escrita habilitadas)
$dir = "arquivos/";

// Recebendo o arquivo multipart
$file = $_FILES["arquivo"];
// Aqui estamos recebendo o arquivo que foi enviado através do formulário HTML.

// Move o arquivo da pasta temporária de upload para a pasta de destino
if (move_uploaded_file($file["tmp_name"],$dir.$file["name"])) {
    // Move o arquivo da pasta temporária para a pasta de destino.
    echo "Arquivo enviado com sucesso";
    // Se a operação for bem-sucedida, exibe uma mensagem de sucesso.
} else {
    echo "Erro!!! O arquivo não pode ser enviado.";
    // Se ocorrer um erro durante a operação, exibe uma mensagem de erro.
}

echo "<br><br> <a href='index.html'> << voltar </a>";
// Exibe um link para voltar à página inicial.
?>
