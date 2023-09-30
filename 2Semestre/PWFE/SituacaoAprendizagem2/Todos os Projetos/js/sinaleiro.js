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
	h = today.getHours().toString().padStart(2, '0'); // Adiciona zero à esquerda se tiver apenas uma casa
	m = today.getMinutes().toString().padStart(2, '0'); // Adiciona zero à esquerda se tiver apenas uma casa
	s = today.getSeconds().toString().padStart(2, '0'); // Adiciona zero à esquerda se tiver apenas uma casa

	// Atualizando o conteúdo do elemento com o ID "txt"
	document.getElementById('txt').innerHTML = h + ":" + m + ":" + s;

	// Atualizando o fundo de acordo com a hora
	if (h >= 12 && h < 18) {
		document.body.style.backgroundImage = "url('img/cidade_tarde_bg.jpg')";
	} else if (h >= 19 || h < 5) {
		document.body.style.backgroundImage = "url('img/cidade_noite_bg.jpg')";
	} else {
		document.body.style.backgroundImage = "url('img/cidade_bg.jpg')";
	}
	 // Verificar se está no horário de manutenção (exemplo: das 2h às 3h)
	 if (h >= 2 && h < 3) {
        manutencao(); // Chama a função de manutenção
    }
	// Chama a função "time" novamente após 500 milissegundos (0.5 segundos)
	setTimeout('time()', 500);
}

let manInterval; // Variável para armazenar o intervalo de manutenção

function manutencao() {
    // Limpa qualquer intervalo de manutenção existente
    clearInterval(manInterval);
	vermelho.classList.remove('vermelho-ativo');
    amarelo.classList.remove('amarelo-ativo');
    verde.classList.remove('verde-ativo');
    // Define um novo intervalo de manutenção de 1 segundo
    manInterval = setInterval(() => {
    // Toggle (alterna) a classe 'amarelo-ativo' no elemento com a classe 'amarelo'
        amarelo.classList.toggle('amarelo-ativo');
    }, 300);
}
function pararManutencao() {
    clearInterval(manInterval); // Limpa o intervalo de manutenção
    amarelo.classList.remove('amarelo-ativo'); // Desativa o semáforo amarelo
}
// Inicializando o contador como 1
let contador = 1;

// Verificando se a hora atual é maior ou igual a 5
if (today = new Date() >= 5) {
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
			verde.classList.remove('verde-ativo');
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
			amarelo.classList.remove('amarelo-ativo');
			contador = 0;
		}
		// Incrementando o contador
		contador += 1;
	}, 1000);
}