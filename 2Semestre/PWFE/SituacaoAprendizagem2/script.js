const vermelho = document.querySelector('.vermelho');
const amarelo = document.querySelector('.amarelo');
const verde = document.querySelector('.verde');

today = new Date();
function time() {
	today = new Date();
	h = today.getHours();
	m = today.getMinutes();
	s = today.getSeconds();
	document.getElementById('txt').innerHTML=h+":"+m+":"+s;
	setTimeout('time()', 500);
}
let contador = 1;

if (today.getHours() <= 19) {
	setInterval(() => {
		if (contador <= 1) {
			vermelho.classList.add('vermelho-ativo');
		} else if (contador === 5) {
			amarelo.classList.add('amarelo-ativo');
			vermelho.classList.remove('vermelho-ativo');
		} else if (contador === 8) {
			verde.classList.add('verde-ativo');
			amarelo.classList.remove('amarelo-ativo');
		} else if (contador === 15) {
			verde.classList.remove('verde-ativo');
			contador = 0;
		}
		contador += 1;
	}, 1000);
} else {
	setInterval(() => {
		if (contador <= 1) {
			amarelo.classList.add('amarelo-ativo');
		} else if (contador === 2) {
			amarelo.classList.remove('amarelo-ativo');
			contador = 0;
		}
		contador += 1;
	}, 1000);

}


