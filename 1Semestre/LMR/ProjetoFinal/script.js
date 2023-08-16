function Preencher() {
    var Nome = document.getElementById('validationCustom01').value;
    var SNome = document.getElementById('validationCustom02').value;
    var Email = document.getElementById('inputEmail1').value;
    var Email2 = document.getElementById('inputEmail2').value;
    var Senha = document.getElementById('inputPassword1').value;
    var Senha2 = document.getElementById('inputPassword2').value;
    var Endereco = document.getElementById('inputAddress').value;
    var Endereco2 = document.getElementById('inputAddress2').value;
    var Cidade = document.getElementById('inputCity').value;
    var Estado = document.getElementById('inputEstado').value;
    var CEP = document.getElementById('inputCEP').value;

    if (Nome == '') {
        alert('Informar Nome');
    } if (SNome == '') {
        alert('Informar Sobrenome');
    } if (Email == '') {
        alert('Informar Email');

    } if (Email2 == '') {
        alert('Informar Email');
    }
    else if (Email2 != Email) {
        alert('Email incorreto');
    }
    if (Senha == '') {
        alert('Informar Senha');

    }
    if (Senha2 == '') {
        alert('Informar Senha');
    }
    else if (Senha2 != Senha) {
        alert('Senha incorreta');
    }
    if (Endereco == '') {
        alert('Informar Endereço');
    } if (Endereco2 == '') {
        alert('Informar Complemento');
    } if (Cidade == '') {
        alert('Informar Cidade');
    } if (Estado == '') {
        alert('Informar Estado');
    } if (CEP == '') {
        alert('Informar CEP');
    }
}