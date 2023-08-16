let ht; // horas trabalhadas
let vh; // valor hora
let pd; //percentual de desconto
let tb; // total de desconto
let sb; // salario bruto
let sl; // salario liquido

ht = prompt('Digite horas trabalhadas: ',' Informe aqui.');
vh = prompt('Entre com o valor da hora:',' Informe aqui');
pd = prompt('Entre com o percentual de desconto:',' em porcentagem');
sb = parseFloat(ht)*parseFloat(vh);
td = parseFloat(pd)*sb/100;
sl = sb - tb;

document.write('Salário = ', sl);