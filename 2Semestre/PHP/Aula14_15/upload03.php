<?php

if (isset($_POST['enviar-formulario'])):
    // Verifica se o formulário foi submetido com o botão "enviar-formulario" 

    $formatos = array("png", "jpg", "jpeg", "gif", "pdf");
    // Lista de formatos de arquivo aceitáveis

    $qtdArquivos = count($_FILES['arquivo']['name']);
    // Conta a quantidade de arquivos enviados através do formulário

    $cont = 0;
    // Inicializa um contador

    while($cont < $qtdArquivos):
        // Loop para processar cada arquivo enviado

        $extensao = pathinfo($_FILES['arquivo']['name'][$cont], PATHINFO_EXTENSION);
        // Obtém a extensão do arquivo

        if(in_array($extensao, $formatos)):
            // Verifica se a extensão do arquivo está na lista de formatos aceitáveis

            $pasta = "arquivos/";
            // Define o diretório onde os arquivos serão salvos

            $temporario = $_FILES['arquivo']['tmp_name'][$cont];
            // Obtém o nome temporário do arquivo

            $novoNome = uniqid().".$extensao";
            // Gera um novo nome único para o arquivo usando o ID único gerado pela função uniqid()

            if(move_uploaded_file($temporario, $pasta.$novoNome)):
                // Move o arquivo temporário para o diretório especificado com o novo nome

                $mensagem = "Upload feito com sucesso.";
                // Se o upload for bem-sucedido, define a mensagem de sucesso
            else:
                $mensagem = "Erro!!! Não foi possível fazer o upload.";
                // Se houver um erro ao mover o arquivo, define a mensagem de erro
            endif;
        else:
            $mensagem = "Formato inválido!!";
            // Se a extensão do arquivo não estiver na lista de formatos aceitáveis, define a mensagem de erro
        endif;

        $cont++;
        // Incrementa o contador para processar o próximo arquivo
    endwhile;
endif;

echo "<br><br> <a href='index.html'> << voltar </a>";
// Exibe um link para voltar à página inicial
?>
