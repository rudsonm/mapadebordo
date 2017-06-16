angular.module("MapaDeBordo").directive("botaoAdicionar", function() {
    return {
        restrict: 'E',
        scope: {
            view: '@'
        },
        link: function(scope) {
            scope.link = "#!/"+scope.view+"/cadastro";
        },
        templateUrl: 'views/shared/botao-adicionar.html'
    }
});

angular.module("MapaDeBordo").directive("botaoAdicionar", function() {
    return {
        restrict: 'E',
        scope: {
            view: '@'
        },
        templateUrl: 'views/shared/botao-voltar.html'
    }
});