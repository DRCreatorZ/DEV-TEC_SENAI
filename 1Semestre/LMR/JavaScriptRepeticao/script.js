function DiaSemana() {
    var Hoje = new Date(document.getElementById('data').value);
    var Dia = Hoje.getDay();
    var Semana = ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"];

    document.write(Semana[Dia]);
    document.write('<br>', Hoje);
}
function ColorirNome() {
    var Cor = new Array('Black', 'Magenta', 'Green', 'Blue', 'Red', 'Yellow', 'Silver');
    var Nome = document.getElementById('pNome').value;

    for (let i = 0; i < Cor.length; i++) {
        document.write(Nome.fontcolor(Cor[i]) + '<br>');
    }
}