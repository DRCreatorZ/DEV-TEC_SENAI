<?php
// Configurações de conexão com o banco de dados
$endereco = 'localhost'; // Endereço do banco de dados
$banco = 'postgres'; // Nome do banco de dados
$usuario = 'postgres'; // Nome de usuário do banco de dados
$senha = 'postgres'; // Senha do banco de dados

try {
    // Estabelece a conexão com o banco de dados usando PDO
    $pdo = new PDO(
        "pgsql:host=$endereco;port=5432;dbname=$banco",
        $usuario,
        $senha,
        [PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION]
    );

    // Consulta todas as tabelas no banco de dados
    $stmt = $pdo->query("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'");
    $tabelas = $stmt->fetchAll(PDO::FETCH_COLUMN);

    // Verifica se há tabelas para exibir
    if (!empty($tabelas)) {
        echo "<h2 style='font-family: Arial, sans-serif;'>Tabelas no banco de dados:</h2>";
        foreach ($tabelas as $tabela) {
            echo "<h3 style='font-family: Arial, sans-serif;'>$tabela</h3>";
            
            // Consulta o conteúdo da tabela
            $stmt = $pdo->query("SELECT * FROM $tabela");
            $registros = $stmt->fetchAll(PDO::FETCH_ASSOC);
            
            // Exibe os registros da tabela em formato de tabela HTML
            echo "<table style='font-family: Arial, sans-serif; border-collapse: collapse; width: 100%;' border='1'>";
            if (!empty($registros)) {
                echo "<tr style='background-color: #f2f2f2;'>";
                foreach ($registros[0] as $campo => $valor) {
                    echo "<th style='padding: 8px; text-align: left;'>$campo</th>";
                }
                echo "</tr>";
                foreach ($registros as $registro) {
                    echo "<tr>";
                    foreach ($registro as $valor) {
                        echo "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>$valor</td>";
                    }
                    echo "</tr>";
                }
            }
            echo "</table>";
        }
    } else {
        echo "<p style='font-family: Arial, sans-serif;'>Não há tabelas no banco de dados.</p>";
    }

} catch (PDOException $e) {
    // Captura e trata erros de conexão
    echo "<p style='font-family: Arial, sans-serif; color: red;'>Falha ao conectar ao banco de dados. <br/>";
    // Exibe a mensagem de erro específica
    die($e->getMessage());
}
?>
