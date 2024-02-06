<?php
$servername = "seu_servidor_mysql";
$username = "seu_usuario_mysql";
$password = "sua_senha_mysql";
$dbname = "todolist";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM tasks";
$result = $conn->query($sql);

$tasks = array();

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $tasks[] = array(
            'id' => $row['id'],
            'task_name' => $row['task_name'],
            'completed' => (bool)$row['completed'],
        );
    }
}

echo json_encode($tasks);

$conn->close();
?>
