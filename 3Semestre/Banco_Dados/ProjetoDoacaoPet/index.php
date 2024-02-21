<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>Página de Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            max-width: 400px;
            margin-top: 50px;
        }

        .logo {
            height: 200px;
            width: 200px;
        }

        h1 {
            font-size: xx-large;
            text-align: center;
            margin-bottom: 30px;
        }

        .form-control {
            margin-bottom: 20px;
        }

        .btn-primary {
            width: 100%;
        }

        .btn-warning {
            width: 100%;
        }

        .botoes {
            display: flex;
            gap: 15px;
            margin-bottom: 50px;
        }
    </style>
</head>

<body>

    <div class="container">
        <?php if (!empty($_GET['msgErro'])) { ?>
            <div class="alert alert-warning" role="alert">
                <?php echo $_GET['msgErro']; ?>
            </div>
        <?php } ?>
        <?php if (!empty($_GET['msgSucesso'])) { ?>
            <div class="alert alert-success" role="alert">
                <?php echo $_GET['msgSucesso']; ?>
            </div>
        <?php } ?>
        <img src="img/salvePet_logo.jpg" alt="" class="logo mx-auto d-block">
        <h1>Olá, seja bem-vindo(a) ao Salve Pet!!!</h1>
        <form action="processa_login.php" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">E-mail</label>
                <input type="email" name="email" id="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <input type="password" name="senha" id="senha" class="form-control" required>
            </div>
            <div class="botoes">
                <button type="submit" name="enviarDados" class="btn btn-primary">Entrar</button>
                <a href="cad_usuario.php" class="btn btn-warning">Cadastrar-se</a>
            </div>
        </form>
    </div>
</body>

</html>