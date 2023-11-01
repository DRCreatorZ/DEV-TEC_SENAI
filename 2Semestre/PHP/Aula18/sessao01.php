<?php
session_start(); // precisa ser chamada antes toda vez.
echo "Seu nome é " . $_SESSION['nome']; /* recupera o valor que veio junto com a requisição */
?>