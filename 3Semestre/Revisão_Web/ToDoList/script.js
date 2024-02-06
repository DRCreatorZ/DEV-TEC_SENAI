document.addEventListener('DOMContentLoaded', function () {
    const taskForm = document.getElementById('taskForm');
    const taskInput = document.getElementById('taskInput');
    const taskList = document.getElementById('taskList');

    // Função para carregar as tarefas do banco de dados
    function loadTasks() {
        fetch('get_tasks.php')
            .then(response => response.json())
            .then(data => {
                taskList.innerHTML = ''; // Limpa a lista
                data.forEach(task => {
                    const listItem = document.createElement('li');
                    listItem.className = 'taskItem';
                    listItem.innerHTML = `
                        <input type="checkbox" ${task.completed ? 'checked' : ''} disabled>
                        <span>${task.task_name}</span>
                    `;
                    taskList.appendChild(listItem);
                });
            });
    }

    // Evento de envio do formulário para adicionar uma nova tarefa
    taskForm.addEventListener('submit', function (event) {
        event.preventDefault();

        fetch('add_task.php', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ task_name: taskInput.value }),
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    loadTasks(); // Recarrega a lista de tarefas
                    taskInput.value = ''; // Limpa o campo de entrada
                }
            });
    });

    // Carrega as tarefas ao carregar a página
    loadTasks();
});
