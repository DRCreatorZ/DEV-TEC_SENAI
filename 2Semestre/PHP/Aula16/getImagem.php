<?php
$host = "localhost";
$username = "root";
$password = "";
$db = "aula16";

// Obter o valor do parâmetro PicNum da solicitação GET
$PicNum = $_GET["PicNum"];
// Aqui estamos pegando o valor do parâmetro "PicNum" da requisição GET.

// Conectar ao banco de dados usando mysqli
$conn = mysqli_connect($host, $username, $password, $db);
// Aqui estamos estabelecendo uma conexão com o banco de dados usando as credenciais fornecidas.

// Verificar a conexão
if (!$conn) {
    die("Impossível conectar ao banco: " . mysqli_connect_error());
}
// Esta parte verifica se a conexão foi bem-sucedida. Se não, ela encerra o script e exibe uma mensagem de erro.

// Escapar o valor do parâmetro para evitar injeção de SQL
$PicNum = mysqli_real_escape_string($conn, $PicNum);
// Aqui estamos escapando o valor do parâmetro "PicNum" para evitar possíveis ataques de injeção de SQL.

// Executar a consulta com o parâmetro escapado
$query = "SELECT * FROM AULA16 WHERE AULA16_ID='$PicNum'";
$result = mysqli_query($conn, $query);
// Aqui estamos construindo e executando uma consulta SQL para buscar um registro na tabela "AULA16" com o ID correspondente ao valor de "PicNum".

if (!$result) {
    die("Impossível executar a query: " . mysqli_error($conn));
}
// Esta parte verifica se a consulta foi bem-sucedida. Se não, ela encerra o script e exibe uma mensagem de erro.

// Verificar se foi encontrado um registro
if (mysqli_num_rows($result) > 0) {
    // Se encontrarmos um registro, estamos prestes a exibir uma imagem.

    // Definir o cabeçalho para indicar que a saída é uma imagem GIF
    header("Content-type: image/gif");
    // Indicamos que a saída será uma imagem GIF.

    // Ler e exibir a imagem armazenada no banco de dados
    $row = mysqli_fetch_object($result);
    echo $row->AULA16_IMG;
    // Lemos a imagem da linha encontrada no banco de dados e a exibimos.
} else {
    // Se nenhum registro for encontrado, você pode exibir uma imagem de erro ou retornar uma mensagem de erro.
    echo "Imagem não encontrada.";
    // Se nenhum registro for encontrado, exibimos uma mensagem indicando que a imagem não foi encontrada.
}

// Fechar a conexão
mysqli_close($conn);
// Por fim, fechamos a conexão com o banco de dados.
?>
