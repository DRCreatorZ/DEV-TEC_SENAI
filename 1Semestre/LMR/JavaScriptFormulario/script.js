function Concatenar() {
    var Nome = document.getElementById('pNome').value;
    var SNome = document.getElementById('pSNome').value;

    alert(Nome + ' ' + SNome);
}

function Somar() {
    var n1 = document.getElementById('MyCalc').pNumero.value;
    var n2 = document.getElementById('MyCalc').pNumero2.value;
    if (n1 == '' || n2 == '') {
        alert("Preencha todos os campos!")
    } else {
        alert('O Resultado é: ' + (parseFloat(n1) + parseFloat(n2)));
    }

}
function Dividir() {
    var n1 = document.getElementById('MyCalc').pNumero.value;
    var n2 = document.getElementById('MyCalc').pNumero2.value;
    if (n1 == '' || n2 == '') {
        alert("Preencha todos os campos!")
    } else {
        if (n2 == 0) {
            alert("NÃO DIVIDIRÁS POR ZERO!")
        } else {
            alert('O Resultado é: ' + (parseFloat(n1) / parseFloat(n2)));
        }
    }
}

function Subtrair() {
    var n1 = document.getElementById('MyCalc').pNumero.value;
    var n2 = document.getElementById('MyCalc').pNumero2.value;
    if (n1 == '' || n2 == '') {
        alert("Preencha todos os campos!")
    } else {
        alert('O Resultado é: ' + (parseFloat(n1) - parseFloat(n2)));
    }
}
function Multiplicar() {
    var n1 = document.getElementById('MyCalc').pNumero.value;
    var n2 = document.getElementById('MyCalc').pNumero2.value;
    if (n1 == '' || n2 == '') {
        alert("Preencha todos os campos!")
    } else {
        alert('O Resultado é: ' + (parseFloat(n1) * parseFloat(n2)));
    }
}