<!DOCTYPE html>
<html>

<head>
    <title>To-Do List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            margin: 0 auto;
            width: 50%;
        }

        h1 {
            text-align: center;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li:not(:last-child) {
            margin-bottom: 10px;
        }

        label {
            display: inline-block;
            margin-right: 10px;
            vertical-align: middle;
        }

        input[type="text"] {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
        }

        button {
            padding: 5px 15px;
            border-radius: 5px;
            border: none;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
        }

        button:hover {
            background-color: #3E8E41;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>To-Do List</h1>
        <form action="add_task.php" method="post">
            <label for="task">New task:</label>
            <input type="text" id="task" name="task" placeholder="Enter task">
            <button type="submit">Add</button>
        </form>
        <ul id="task-list">

        </ul>
    </div>
</body>

</html>
<?php
// Verifica se a variável $_POST['task'] está definida e não está vazia
if (isset($_POST['task']) && !empty($_POST['task'])) {
    // Adiciona a tarefa à lista
    echo "<li>" . htmlspecialchars($_POST['task']) . "</li>";
}
?>