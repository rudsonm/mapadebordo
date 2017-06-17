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
        }).
        when("/portos", {
            templateUrl: "views/porto/lista.html",
            controller: "PortoController",
            controllerAs: "portoVm"
        })
        .when("/portos/cadastro", {
            templateUrl: "views/porto/cadastro.html",
            controller: "PortoController",
            controllerAs: "portoVm"
        })
        .when("/viagens", {
            templateUrl: "views/viagem/lista.html",
            controller: "ViagemController",
            controllerAs: "viagemVm"
        })
        .when("/viagens/cadastro", {
            templateUrl: "views/viagem/cadastro.html",
            controller: "ViagemController",
            controllerAs: "viagemVm"
        })
        .otherwise({
            redirectTo: "/especies"
        });
    });
    
    $(document).ready(function () {
        $(".button-collapse").sideNav();
    });
})();