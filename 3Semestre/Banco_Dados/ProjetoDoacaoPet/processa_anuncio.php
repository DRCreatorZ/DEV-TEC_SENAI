<?php
require_once 'conectaBD.php';

// Criação da tabela 'anuncio' se ela não existir
try {
    $sqlCreateTable = "CREATE TABLE IF NOT EXISTS anuncio (
        id SERIAL PRIMARY KEY,
        fase VARCHAR(255),
        tipo VARCHAR(255),
        porte VARCHAR(255),
        sexo VARCHAR(255),
        pelagem_cor VARCHAR(255),
        raca VARCHAR(255),
        observacao TEXT,
        email_usuario VARCHAR(255)
    )";

    $stmtCreateTable = $pdo->prepare($sqlCreateTable);
    $stmtCreateTable->execute();

    echo "Tabela 'anuncio' criada com sucesso!";
} catch (PDOException $e) {
    die("Erro ao criar tabela 'anuncio': " . $e->getMessage());
}

// Inserção de dados na tabela 'anuncio'
session_start();
if (empty($_SESSION)) {
    header("Location: index.php?msgErro=Você precisa se autenticar no sistema.");
    die();
}

if (!empty($_POST)) {
    if ($_POST['enviarDados'] == 'CAD') {
        try {
            $sqlInsert = "INSERT INTO anuncio
                (fase, tipo, porte, sexo, pelagem_cor, raca, observacao, email_usuario)
                VALUES
                (:fase, :tipo, :porte, :sexo, :pelagem_cor, :raca, :observacao, :email_usuario)";

            $stmtInsert = $pdo->prepare($sqlInsert);
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

            if ($stmtInsert->execute($dados)) {
                header("Location: index_logado.php?msgSucesso=Anúncio cadastrado com sucesso!");
            }
        } catch (PDOException $e) {
            header("Location: index_logado.php?msgErro=Falha ao cadastrar anúncio.");
        }
    } elseif ($_POST['enviarDados'] == 'ALT') {
        try {
            $sql = "UPDATE
                anuncio
                SET
                fase = :fase,
                tipo = :tipo,
                porte = :porte,
                pelagem_cor = :pelagem_cor,
                raca = :raca,
                sexo = :sexo,
                observacao = :observacao
                WHERE
                id = :id_anuncio AND
                email_usuario = :email";

            $dados = array(
                ':id_anuncio' => $_POST['id_anuncio'],
                ':fase' => $_POST['fase'],
                ':tipo' => $_POST['tipo'],
                ':porte' => $_POST['porte'],
                ':pelagem_cor' => $_POST['pelagemCor'],
                ':raca' => $_POST['raca'],
                ':sexo' => $_POST['sexo'],
                ':observacao' => $_POST['observacao'],
                ':email' => $_SESSION['email']
            );
            $stmt = $pdo->prepare($sql);
            if ($stmt->execute($dados)) {
                header("Location: index_logado.php?msgSucesso=Alteração realizada com sucesso!!");
            } else {
                header("Location: index_logado.php?msgErro=Falha ao ALTERAR anúncio..");
            }
        } catch (PDOException $e) {
            header("Location: index_logado.php?msgErro=Falha ao ALTERAR anúncio..");
        }
    } elseif ($_POST['enviarDados'] == 'DEL') {
        try {
            $sql = "DELETE FROM anuncio WHERE id = :id_anuncio AND email_usuario = :email";
            $stmt = $pdo->prepare($sql);
            $dados = array(':id_anuncio' => $_POST['id_anuncio'], ':email' => $_SESSION['email']);
            if ($stmt->execute($dados)) {
                header("Location: index_logado.php?msgSucesso=Anúncio excluído com sucesso!!");
            } else {
                header("Location: index_logado.php?msgErro=Falha ao EXCLUIR anúncio..");
            }
        } catch (PDOException $e) {
            header("Location: index_logado.php?msgErro=Falha ao EXCLUIR anúncio..");
        }
    } else {
        header("Location: index_logado.php?msgErro=Operação inválida.");
    }
} else {
    header("Location: index_logado.php?msgErro=Erro de acesso.");
}

// Redirecionar para a página inicial (index_logado) com mensagem de erro/sucesso
die();
?>
