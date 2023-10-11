<template>
  <div id="app">
    <header>
      <h1>Meu Catálogo de Filmes e Livros</h1>
      <button @click="toggleView">Filmes/Livros</button>
    </header>
    <main>
      <CatalogoDeFilmes v-if="showMovies" />
      <CatalogoDeLivros v-else />
    </main>
    <footer>
      <h1>D.R.C</h1>
    </footer>
  </div>
</template>

<script>
import CatalogoDeFilmes from "@/components/CatalogoDeFilmes.vue";
import CatalogoDeLivros from "./components/CatalogoDeLivros.vue";

export default {
  components: {
    CatalogoDeFilmes,
    CatalogoDeLivros
  },
  data() {
    return {
      showMovies: true
    };
  },
  methods: {
    toggleView() {
      this.showMovies = !this.showMovies;
    }
  }
};
</script>

  <style>
  #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
  }
  
  header {
  
  background-color: #35495e;
  color: #fff;
  padding: 10px 0;
  }

  footer {
  
  background-color: #35495e;
  color: #fff;
  padding: 10px 0;
  position: fixed;
  left: 5px;
  right: 5px;
  bottom: 0px;
  height: 50px;
  margin-bottom: 5px;
  }
  </style>