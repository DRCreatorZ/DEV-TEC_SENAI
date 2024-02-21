<?php
session_start();
if (empty($_SESSION)) {
    // Significa que as variáveis de SESSAO não foram definidas.
    // Não poderia acessar aqui.
    header("Location: index.php?msgErro=Você precisa se autenticar no sistema.");
    die();
}
?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <title>Cadastrar Novo Anúncio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-
+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
            margin-bottom: 50px;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        label {
            font-weight: bold;
        }

        .form-select,
        .form-control {
            margin-bottom: 20px;
        }

        button[type="submit"],
        a.btn {
            width: 150px;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>Cadastrar Novo Anúncio de Animal para Adoção</h1>
        <form action="processa_anuncio.php" method="post">
            <div class="row g-3">
                <div class="col-md-4">
                    <label for="fase" class="form-label">Fase</label>
                    <select class="form-select" name="fase" id="fase">
                        <option selected>Selecione a fase do animal</option>
                        <option value="F">Filhote</option>
                        <option value="A">Adulto</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="tipo" class="form-label">Tipo</label>
                    <select class="form-select" name="tipo" id="tipo">
                        <option selected>Selecione o tipo do animal</option>
                        <option value="G">Gato</option>
                        <option value="C">Cachorro</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="porte" class="form-label">Porte</label>
                    <select class="form-select" name="porte" id="porte">
                        <option selected>Selecione o porte do animal</option>
                        <option value="P">Pequeno</option>
                        <option value="M">Médio</option>
                        <option value="G">Grande</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="pelagemCor" class="form-label">Pelagem / Cor</label>
                    <input type="text" name="pelagemCor" id="pelagemCor" class="form-control">
                </div>
                <div class="col-md-4">
                    <label for="raca" class="form-label">Raça</label>
                    <input type="text" name="raca" id="raca" class="form-control">
                </div>
                <div class="col-md-4">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="sexo" value="M" id="sexoM">
                        <label class="form-check-label" for="sexoM">
                            Macho
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="sexo" value="F" id="sexoF">
                        <label class="form-check-label" for="sexoF">
                            Fêmea
                        </label>
                    </div>
                </div>
                <div class="col-md-4">
                    <label for="observacao" class="form-label">Observações</label>
                    <textarea name="observacao" class="form-control" id="observacao" rows="3"></textarea>
                </div>
            </div>
            <br>
            <button type="submit" name="enviarDados" value="CAD" class="btn btn-primary">Cadastrar</button>
            <a href="index_logado.php" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</body>

</html>