// Importação dos módulos http, fs e path
const http = require("http");
const fs = require("fs");
const path = require("path");

// Definição da porta do servidor e caminho do arquivo JSON
const PORT = 3000;
const JSON_FILE_PATH = path.join(__dirname, "db.json");

// Criação do servidor HTTP
const server = http.createServer((req, res) => {
  // Verifica se a requisição é do tipo GET e a rota é '/usuarios'
  if (req.method === "GET" && req.url === "/usuarios") {
    // Lendo o arquivo JSON
    fs.readFile(JSON_FILE_PATH, (err, data) => {
      if (err) {
        // Se houver erro na leitura do arquivo, retorna status 500 com mensagem de erro
        res.writeHead(500, { "Content-Type": "application/json" });
        res.end(JSON.stringify({ error: "Erro ao ler o arquivo JSON." }));
      } else {
        // Se a leitura for bem-sucedida, retorna status 200 com o conteúdo do arquivo JSON
        res.writeHead(200, { "Content-Type": "application/json" });
        res.end(data);
      }
    });
  } else {
    // Se a rota não for '/usuarios', retorna status 404 com mensagem de erro
    res.writeHead(404, { "Content-Type": "application/json" });
    res.end(JSON.stringify({ error: "Rota não encontrada." }));
  }
});

// Inicia o servidor na porta especificada
server.listen(PORT, () => {
  console.log(
    `Servidor Node.js está rodando na porta ${PORT} http://localhost:${PORT}/usuarios`
  );
});
