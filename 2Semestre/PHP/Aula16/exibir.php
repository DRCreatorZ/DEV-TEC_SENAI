<?php
$host = "localhost";
$username = "root";
$password = "";
$db = "aula16";

echo "<h1>Imagens: Banco de dados_Aula 16</h1>";

// Conectar ao banco de dados usando mysqli
$conn = mysqli_connect($host, $username, $password, $db);

// Verificar a conexão
if (!$conn) {
    die("Impossível conectar ao banco: " . mysqli_connect_error());
}

// Executar a consulta
$query = "SELECT * FROM AULA16";
$result = mysqli_query($conn, $query);

if (!$result) {
    die("Impossível executar a query: " . mysqli_error($conn));
}

// Exibir as imagens
while ($row = mysqli_fetch_object($result)) {
    echo "<hr>";
    echo "<img src='getImagem.php?PicNum={$row->AULA16_ID}' style='height: 100px; margin: 10px;'>";
}

// Fechar a conexão
mysqli_close($conn);
echo "<br><br> <a href='index.php'> << voltar </a>";
?>
