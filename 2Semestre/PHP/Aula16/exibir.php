<?php
$host = "localhost";
$username = "root";
$password = "";
$db = "aula16";

// Exibe um título na página
echo "<h1>Imagens: Banco de dados_Aula 16</h1>";

// Conectar ao banco de dados usando mysqli
$conn = mysqli_connect($host, $username, $password, $db);
// Estabelece uma conexão com o banco de dados usando as credenciais fornecidas.

// Verificar a conexão
if (!$conn) {
    die("Impossível conectar ao banco: " . mysqli_connect_error());
}
// Verifica se a conexão foi bem-sucedida. Se não, encerra o script e exibe uma mensagem de erro.

// Executar a consulta
$query = "SELECT * FROM AULA16";
$result = mysqli_query($conn, $query);
// Executa uma consulta SQL para obter todas as entradas da tabela "AULA16".

if (!$result) {
    die("Impossível executar a query: " . mysqli_error($conn));
}
// Verifica se a consulta foi bem-sucedida. Se não, encerra o script e exibe uma mensagem de erro.

// Exibir as imagens
while ($row = mysqli_fetch_object($result)) {
    // Loop que percorre os resultados da consulta.
    echo "<hr>";
    echo "<img src='getImagem.php?PicNum={$row->AULA16_ID}' style='height: 100px; margin: 10px;'>";
    // Exibe uma imagem e inclui um link para "getImagem.php" passando o ID da imagem como parâmetro.
}

// Fechar a conexão
mysqli_close($conn);
// Fecha a conexão com o banco de dados.

echo "<br><br> <a href='index.php'> << voltar </a>";
// Exibe um link para voltar à página inicial.
?>
