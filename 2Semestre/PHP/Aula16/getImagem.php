<?php
$host = "localhost";
$username = "root";
$password = "";
$db = "aula16";

// Obter o valor do parâmetro PicNum da solicitação GET
$PicNum = $_GET["PicNum"];

// Conectar ao banco de dados usando mysqli
$conn = mysqli_connect($host, $username, $password, $db);

// Verificar a conexão
if (!$conn) {
    die("Impossível conectar ao banco: " . mysqli_connect_error());
}

// Escapar o valor do parâmetro para evitar injeção de SQL
$PicNum = mysqli_real_escape_string($conn, $PicNum);

// Executar a consulta com o parâmetro escapado
$query = "SELECT * FROM AULA16 WHERE AULA16_ID='$PicNum'";
$result = mysqli_query($conn, $query);

if (!$result) {
    die("Impossível executar a query: " . mysqli_error($conn));
}

// Verificar se foi encontrado um registro
if (mysqli_num_rows($result) > 0) {
    // Definir o cabeçalho para indicar que a saída é uma imagem GIF
    header("Content-type: image/gif");

    // Ler e exibir a imagem armazenada no banco de dados
    $row = mysqli_fetch_object($result);
    echo $row->AULA16_IMG;
} else {
    // Se nenhum registro for encontrado, você pode exibir uma imagem de erro ou retornar uma mensagem de erro.
    echo "Imagem não encontrada.";
}

// Fechar a conexão
mysqli_close($conn);
?>
