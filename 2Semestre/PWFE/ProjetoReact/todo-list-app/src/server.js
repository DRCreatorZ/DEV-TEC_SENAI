
const express = require('express');
const { Pool } = require('pg');

const app = express();
const port = 3001; // Porta que o servidor vai ouvir

// Configuração do pool de conexões com o PostgreSQL
const pool = new Pool({
  user: 'seu_usuario',
  host: 'localhost',
  database: 'sua_database',
  password: 'sua_senha',
  port: 5432,
});

// Middleware para permitir o corpo das solicitações JSON
app.use(express.json());

// Endpoint para obter todas as tarefas
app.get('/api/tasks', async (req, res) => {
  try {
    const { rows } = await pool.query('SELECT * FROM tasks');
    res.json(rows);
  } catch (err) {
    console.error('Erro ao obter tarefas:', err);
    res.status(500).json({ error: 'Erro ao obter tarefas' });
  }
});

// Endpoint para adicionar uma nova tarefa
app.post('/api/tasks', async (req, res) => {
  const { task } = req.body;
  try {
    await pool.query('INSERT INTO tasks (task) VALUES ($1)', [task]);
    res.sendStatus(201);
  } catch (err) {
    console.error('Erro ao adicionar tarefa:', err);
    res.status(500).json({ error: 'Erro ao adicionar tarefa' });
  }
});

// Endpoint para deletar uma tarefa
app.delete('/api/tasks/:id', async (req, res) => {
  const taskId = req.params.id;
  try {
    await pool.query('DELETE FROM tasks WHERE id = $1', [taskId]);
    res.sendStatus(200);
  } catch (err) {
    console.error('Erro ao deletar tarefa:', err);
    res.status(500).json({ error: 'Erro ao deletar tarefa' });
  }
});

// Inicia o servidor
app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
