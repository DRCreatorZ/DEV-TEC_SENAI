// A função atualizarPlacar() é definida para atualizar os elementos HTML que exibem o placar do jogo com o número de vitórias para o jogador (J1) e a CPU.

// Elementos HTML são obtidos por meio de seus IDs, como mensagemVitoria, mensagemEmpate, mensagemDerrota, contadorJOGADOR, contadorCPU, e são armazenados em variáveis.

// Os elementos de mensagem (Vitória, Empate, Derrota) são inicialmente ocultados definindo seus estilos display para "none".

// Três variáveis são inicializadas: cpuP para rastrear o número de vitórias da CPU, J1P para rastrear o número de vitórias do jogador J1 e eP para rastrear o número de empates.

// Os elementos de exibição do placar são atualizados com os valores iniciais (zero) definindo o textContent dos elementos contadorJOGADOR e contadorCPU.

// A seguir, o código define três funções: Pedra(), Papel(), e Tesoura(). Cada uma delas representa a escolha do jogador (Pedra, Papel ou Tesoura) e executa a lógica do jogo:

// Cada função gera um número aleatório entre 0 e 9 para simular a escolha da CPU.

// Em seguida, as imagens dos elementos imgCPU e imgJogador são atualizadas para mostrar a escolha da CPU e do jogador, respectivamente.

// Com base na escolha da CPU e na escolha do jogador, a função determina o resultado do jogo (vitória, empate ou derrota).

// A mensagem apropriada (Vitória, Empate ou Derrota) é exibida ajustando os estilos dos elementos de mensagem correspondentes.

// O placar é atualizado chamando a função atualizarPlacar(), que atualiza os valores exibidos nos elementos contadorJOGADOR e contadorCPU.
//=========================================================================================================================================
//Define variaveis de placar e define valor como zero
var cpuP = 0;
var J1P = 0;
var eP = 0;
atualizarPlacar();
//atuaizar placar, faz o placar iniciar em Zero
//define variaveis de saida: "vitoria", "empate", "derrota", placar da CPU e GPU
var mensagemVitoria = document.getElementById("mensagemVitoria");
var mensagemEmpate = document.getElementById("mensagemEmpate");
var mensagemDerrota = document.getElementById("mensagemDerrota");
var contadorJOGADOR = document.getElementById("contadorJOGADOR");
var contadorCPU = document.getElementById("contadorCPU");
//oculta as mensagens de vitoria, empate e derrota no inicio do jogo
mensagemEmpate.style.display = "none";
mensagemVitoria.style.display = "none";
mensagemDerrota.style.display = "none";
//encontra no html o local do placar e abribui o valor
contadorJOGADOR.style.display = J1P;
contadorCPU.style.display = cpuP;
//Atualiza o placar
function atualizarPlacar() {
  document.getElementById("contadorJOGADOR").textContent = "Player: " + J1P;
  document.getElementById("contadorCPU").textContent = "CPU: " + cpuP;
}
//Execução caso o jogador escolha Pedra
function Pedra() {
  var cpu = Math.floor(Math.random() * 10);
  // Obtém o elemento de imagem pelo ID
  var imgCPU = document.getElementById("imgCPU");
  var imgJogador = document.getElementById("imgJogador");
  // Atualiza o atributo src para exibir a imagem correta
  imgJogador.src = "img/pedra.png";
  
  if (cpu <= 3) {
    imgCPU.src = "img/pedra.png";
    mensagemEmpate.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemDerrota.style.display = "none";
    eP++;
  } else if (cpu > 3 && cpu <= 6) {
    imgCPU.src = "img/papel.png";
    mensagemDerrota.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemEmpate.style.display = "none";
    cpuP++;
  } else {
    imgCPU.src = "img/tesoura.png";
    mensagemVitoria.style.display = "block";
    mensagemEmpate.style.display = "none";
    mensagemDerrota.style.display = "none";
    J1P++;
  }
  atualizarPlacar();
}
//Execução caso o jogador escolha Papel
function Papel() {
  var cpu = Math.floor(Math.random() * 10);
  // Obtém o elemento de imagem pelo ID
  var imgCPU = document.getElementById("imgCPU");
  var imgJogador = document.getElementById("imgJogador");
  // Atualiza o atributo src para exibir a imagem correta
  imgJogador.src = "img/papel.png";

  if (cpu <= 3) {
    imgCPU.src = "img/pedra.png";
    mensagemVitoria.style.display = "block";
    mensagemEmpate.style.display = "none";
    mensagemDerrota.style.display = "none";
    J1P++;
  } else if (cpu > 3 && cpu <= 6) {
    imgCPU.src = "img/papel.png";
    mensagemEmpate.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemDerrota.style.display = "none";
    eP++;
  } else {
    imgCPU.src = "img/tesoura.png";
    mensagemDerrota.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemEmpate.style.display = "none";
    cpuP++;
  }
  atualizarPlacar();
}
//Execução caso o jogador escolha Tesoura
function Tesoura() {
  var cpu = Math.floor(Math.random() * 10);
  // Obtém o elemento de imagem pelo ID
  var imgCPU = document.getElementById("imgCPU");
  var imgJogador = document.getElementById("imgJogador");
  // Atualiza o atributo src para exibir a imagem correta
  imgJogador.src = "img/tesoura.png";

  if (cpu <= 3) {
    imgCPU.src = "img/pedra.png";
    mensagemDerrota.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemEmpate.style.display = "none";
    cpuP++;
  } else if (cpu > 3 && cpu <= 6) {
    imgCPU.src = "img/papel.png";
    mensagemVitoria.style.display = "block";
    mensagemEmpate.style.display = "none";
    mensagemDerrota.style.display = "none";
    J1P++;
  } else {
    imgCPU.src = "img/tesoura.png";
    mensagemEmpate.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemDerrota.style.display = "none";
    eP++;
  }
  atualizarPlacar();
}