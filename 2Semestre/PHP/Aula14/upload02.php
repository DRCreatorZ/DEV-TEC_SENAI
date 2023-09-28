<?php

if (isset($_POST['enviar-formulario'])):
    $formatos = array("png", "jpg", "jpeg", "gif", "pdf");
    $extensao = pathinfo($_FILES['arquivo']['name'], PATHINFO_EXTENSION);

    if(in_array($extensao, $formatos)):
        //echo "Existe";
        $pasta = "arquivos/";
        $temporario = $_FILES['arquivo']['tmp_name'];
        $novoNome = uniqid().".$extensao";

        if(move_uploaded_file($temporario, $pasta.$novoNome)):
            $mensagem = "Upload feito com sucesso.";
        else:
            $mensagem = "Erro, não foi possivel fazer o upload.";
        endif;
    else:
        //echo "Não existe";
        $mensagem = "Formato inválido!!";
    endif;
    echo $mensagem;
endif;
echo "<br> <a href='index.html'> << voltar </a>";
?>