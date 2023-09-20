<?php
function verificarTriangulo($lado1, $lado2, $lado3) {
    // Verifica se cada lado é positivo
    if ($lado1 <= 0 || $lado2 <= 0 || $lado3 <= 0) {
        return "Os lados do triângulo devem ser positivos.";
    }

    // Verifica a condição de formação de triângulos
    if ($lado1 < $lado2 + $lado3 && $lado2 < $lado1 + $lado3 && $lado3 < $lado1 + $lado2) {
        // Verifica o tipo de triângulo
        if ($lado1 == $lado2 && $lado2 == $lado3) {
            return "Triângulo Equilátero";
        } elseif ($lado1 == $lado2 || $lado1 == $lado3 || $lado2 == $lado3) {
            return "Triângulo Isósceles";
        } else {
            return "Triângulo Escaleno";
        }
    } else {
        return "Os valores não representam os lados de um triângulo.";
    }
}
?>
