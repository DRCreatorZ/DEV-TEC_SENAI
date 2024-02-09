<?php
// Verifica se a requisição é do tipo POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Verifica se o campo de tarefa foi enviado
    if (isset($_POST["task"]) && !empty($_POST["task"])) {
        $task = $_POST["task"];

        // Conexão com o banco de dados (ajuste as credenciais conforme necessário)
        $servername = "localhost";
        $username = "root";
        $password = "";
        $dbname = "todolist";

        // Cria a conexão
        $conn = new mysqli($servername, $username, $password, $dbname);

        // Verifica a conexão
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

        // Prepara e executa a query SQL para inserir a tarefa no banco de dados
        $sql = "INSERT INTO tasks (task_description) VALUES ('$task')";

        if ($conn->query($sql) === TRUE) {
            echo "New record created successfully";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }

        $conn->close();
    } else {
        echo "Task field is empty";
    }
} else {
    echo "Invalid request method";
}
?>
