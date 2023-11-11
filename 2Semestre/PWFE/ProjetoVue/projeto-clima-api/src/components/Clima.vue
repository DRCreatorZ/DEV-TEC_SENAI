<template>
    <!-- O elemento raiz do componente com uma classe condicional com base na temperatura-->
    <div id="clima" :class="typeof weather.main != 'undefined' && weather.main.temp > 22 ? 'warm' : ''">
        <!-- Área principal do componente -->
        <main>
            <!-- Caixa de pesquisa para inserir o nome da cidade -->
            <div class="search-box">

                <input type="text" class="search-bar" placeholder="Search..." v-model="query" @keypress="fetchClima" />

            </div>
            <!-- Se houver dados de clima disponíveis, exiba-os -->
            <div class="weather-wrap" v-if="typeof weather.main != 'undefined'">
                <!-- Caixa de localização exibindo nome da cidade e país -->
                <div class="location-box">
                    <div class="location"> {{ weather.name }} , {{ weather.sys.country

                    }}</div>

                    <!-- Exibe a data formatada usando a função dateBuilder() -->
                    <div class="date"> {{ dataConstrutor() }}</div>
                </div>
                <!-- Caixa de informações sobre o clima, exibindo temperatura e condição do tempo -->

                <div class="weather-box">
                    <div class="temp"> {{ Math.round(weather.main.temp) }} °C</div>
                    <div class="weather"> {{ weather.weather[0].main }}</div>
                </div>
            </div>
        </main>
    </div>
</template>

<script>
export default {
    // Definindo o nome do componente
    name: 'Clima',
    // Dados do componente, incluindo chave de API, URL base, consulta de pesquisa, e dados meteorológicos
    data() {
        return {
            api_key: '681126f28e7d6fa3a7cfe0da0671e599',
            url_base: 'https://api.openweathermap.org/data/2.5/',
            query: '',
            weather: {}
        }
    },
    methods: {
        // Método para buscar dados de clima ao pressionar a tecla Enter na caixa de pesquisa
        fetchClima(e) {
            if (e.key == "Enter") {
                // Faz uma solicitação à API OpenWeatherMap usando fetch
                fetch(`${this.url_base}weather?q=${this.query}&units=metric&APPID=${this.api_key} `)

                    // Converte a resposta para JSON
                    .then(res => {
                        return res.json();
                    })
                    // Chama o método setResults para atualizar os dados meteorológicos no componente

                    .then(this.setResults);
            }
        },
        // Método para atualizar os dados meteorológicos com os resultados da API
        setResults(results) {
            this.weather = results;
        },
        // Função para formatar a data e retornar uma string formatada
        dataConstrutor() {
            let d = new Date();
            let meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",

                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]

            let dias = ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"];

            let dia = dias[d.getDay()];
            let semana = d.getDate();

            let mes = meses[d.getMonth()];
            let ano = d.getFullYear();
            // Retorna a data formatada como uma string
            return `${dia} ${semana} ${mes} ${ano} `;
        }
    }
}
</script>