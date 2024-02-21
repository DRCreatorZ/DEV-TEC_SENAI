<?php
require_once 'conectaBD.php';
session_start();
if (empty($_SESSION)) {
    // Significa que as variáveis de SESSAO não foram definidas.
    // Não pode acessar aqui.
    header("Location: index.php?msgErro=Você precisa se autenticar no sistema.");
    die();
}

if (!empty($_POST)) {
    if ($_POST['enviarDados'] == 'CAD') {
        try {
            $sql = "INSERT INTO anuncio
                    (fase, tipo, porte, sexo, pelagem_cor, raca, observacao, email_usuario)
                    VALUES
                    (:fase, :tipo, :porte, :sexo, :pelagem_cor, :raca, :observacao, :email_usuario)";
            $stmt = $pdo->prepare($sql);
            $dados = array(
                ':fase' => $_POST['fase'],
                ':tipo' => $_POST['tipo'],
                ':porte' => $_POST['porte'],
                ':sexo' => $_POST['sexo'],
                ':pelagem_cor' => $_POST['pelagemCor'],
                ':raca' => $_POST['raca'],
                ':observacao' => $_POST['observacao'],
                ':email_usuario' => $_SESSION['email']
            );
            if ($stmt->execute($dados)) {
                header("Location: index_logado.php?msgSucesso=Anúncio cadastrado com sucesso!");
                exit(); // Encerra o script após redirecionar
            }
        } catch (PDOException $e) {
            die($e->getMessage());
            header("Location: index_logado.php?msgErro=Falha ao cadastrar anúncio..");
            exit(); // Encerra o script após redirecionar
        }
    } else {
        header("Location: index_logado.php?msgErro=Erro de acesso (Operação não definida).");
        exit(); // Encerra o script após redirecionar
    }
} else {
    header("Location: index_logado.php?msgErro=Erro de acesso.");
    exit(); // Encerra o script após redirecionar
}
?>
