<?php
$servername = "seu_servidor_mysql";
$username = "seu_usuario_mysql";
$password = "sua_senha_mysql";
$dbname = "todolist";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$data = json_decode(file_get_contents("php://input"));

$task_name = $data->task_name;

$sql = "INSERT INTO tasks (task_name) VALUES ('$task_name')";
$result = $conn->query($sql);

$response = array('success' => false);

if ($result) {
    $response['success'] = true;
}

echo json_encode($response);

$conn->close();
?>
