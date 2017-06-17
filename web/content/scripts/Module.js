(function() {
    angular.module('MapaDeBordo', ['ngRoute']);

    angular.module('MapaDeBordo').config(function($routeProvider) {
        $routeProvider
        .when("/especies", {
            templateUrl: "views/especie/lista.html",
            controller: "EspecieController",
            controllerAs: "especieVm"
        })
        .when("/especies/cadastro", {
            templateUrl: "views/especie/cadastro.html",
            controller: "EspecieController",
            controllerAs: "especieVm"
        })
        .when("/embarcacoes", {
            templateUrl: "views/embarcacao/lista.html",
            controller: "EmbarcacaoController",
            controllerAs: "embarcacaoVm"
        })
        .when("/embarcacoes/cadastro", {
            templateUrl: "views/embarcacao/cadastro.html",
            controller: "EmbarcacaoController",
            controllerAs: "embarcacaoVm"
        })
        .otherwise({
            redirectTo: "/especies"
        });
    });
    
    $(document).ready(function () {
        $(".button-collapse").sideNav();
    });
})();