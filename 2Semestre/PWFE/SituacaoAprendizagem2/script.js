// Selecionando os elementos com as classes "vermelho", "amarelo" e "verde"
const vermelho = document.querySelector('.vermelho');
const amarelo = document.querySelector('.amarelo');
const verde = document.querySelector('.verde');

// Obtendo a data e hora atual
today = new Date();

// Função para atualizar o relógio
function time() {
	// Atualizando a data e hora atual
	today = new Date();
	h = today.getHours();
	m = today.getMinutes();
	s = today.getSeconds();

	// Atualizando o conteúdo do elemento com o ID "txt"
	document.getElementById('txt').innerHTML=h+":"+m+":"+s;

	// Chama a função "time" novamente após 500 milissegundos (0.5 segundos)
	setTimeout('time()', 500);
}

// Inicializando o contador como 1
let contador = 1;

// Verificando se a hora atual é maior ou igual a 5
if (today.getHours() >= 5) {
	// Executando um conjunto de ações a cada 1000 milissegundos (1 segundo)
	setInterval(() => {
		// Verificando o valor do contador
		if (contador <= 1) {
			// Adicionando a classe 'vermelho-ativo' ao elemento com a classe 'vermelho'
			vermelho.classList.add('vermelho-ativo');
		} else if (contador === 5) {
			// Adicionando a classe 'amarelo-ativo' ao elemento com a classe 'amarelo'
			// Removendo a classe 'vermelho-ativo' do elemento com a classe 'vermelho'
			amarelo.classList.add('amarelo-ativo');
			vermelho.classList.remove('vermelho-ativo');
		} else if (contador === 8) {
			// Adicionando a classe 'verde-ativo' ao elemento com a classe 'verde'
			// Removendo a classe 'amarelo-ativo' do elemento com a classe 'amarelo'
			verde.classList.add('verde-ativo');
			amarelo.classList.remove('amarelo-ativo');
		} else if (contador === 15) {
			// Removendo a classe 'verde-ativo' do elemento com a classe 'verde'
			contador = 0;
		}
		// Incrementando o contador
		contador += 1;
	}, 1000);
} else {
	// Executando um conjunto de ações a cada 1000 milissegundos (1 segundo)
	setInterval(() => {
		// Verificando o valor do contador
		if (contador <= 1) {
			// Adicionando a classe 'amarelo-ativo' ao elemento com a classe 'amarelo'
			amarelo.classList.add('amarelo-ativo');
		} else if (contador === 2) {
			// Removendo a classe 'amarelo-ativo' do elemento com a classe 'amarelo'
			contador = 0;
		}
		// Incrementando o contador
		contador += 1;
	}, 1000);
}
