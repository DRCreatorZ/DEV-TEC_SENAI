<template>
    <div class="catalogo-livros">
    <h2>Catálogo de Livros</h2>
    <input v-model="novoLivro" @keyup.enter="adicionarLivro"
    placeholder="Digite um novo filme" />
    <button @click="adicionarLivro(livro)">Adicionar Livro</button>
    <ul>
    <li v-for="(livro, index) in livros" :key="index">
    {{ livro.titulo }}
    <button @click="alternarStatus(livro)">Marcar como {{
    livro.lido ? 'Não Lido' : 'Lido' }}</button>
    </li>
    </ul>
    </div>
    </template>
    
    <script>
    export default {
    data() {
    return {
    novoLivro: "",
    livros: [],
    };
    },
    methods: {
    adicionarLivro() {
    if (this.novoLivro.trim() !== "") {
    this.livros.push({ titulo: this.novoLivro, lido: false });
    this.novoLivro = "";
    }
    },
    alternarStatus(livro) {
    livro.lido = !livro.lido;
    },
    },
    };
    </script>
    
    <style scoped>
    .catalogo-livros {
    margin: 20px;
    }
    
    ul {
    list-style-type: none;
    padding: 0;
    }
    li {
    margin: 10px 0;
    }
    </style>