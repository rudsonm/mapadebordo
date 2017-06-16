angular.module("MapaDeBordo").directive('cabecalho', function() {
    return {
        restrict: 'E',
        scope: {
            title: '@'
        },
        templateUrl: 'views/shared/header.html'
    }
});