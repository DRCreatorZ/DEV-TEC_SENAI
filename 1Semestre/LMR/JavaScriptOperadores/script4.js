let operacao;
let numero1, numero2;

operacao = prompt("Digite operação Desejada", "+, -, *, /")
numero1 = prompt("Digite um Nº");
numero2 = prompt("Digite um Nº");
switch (operacao) {
    case ("+"): document.write(parseInt(numero1) + parseInt(numero2));
        break;
    case ("-"): document.write(parseInt(numero1) - parseInt(numero2));
        break;
    case ("*"): document.write(parseInt(numero1) * parseInt(numero2));
        break;
    case ("/"):
        if (numero2 == 0) {
            document.write("NÃO DIVIDIRÁS POR ZERO!")
        } else {
            document.write(parseFloat(numero1) / parseFloat(numero2));
        }
        break;
    default: document.write("Escolha uma Operação válida!")
        break;
}