(function() {
    angular.module("MapaDeBordo").controller("ViagemController", function($http) {
        var viagemVm = this;                
        
        function _buscarEmbarcacoes() {
            $http.get("http://localhost:8080/mapadebordo/api/embarcacoes").then(function(response) {
                viagemVm.embarcacoes = response.data;
                setTimeout(function() {
                   $("#ViagemEmbarcacao").material_select(); 
                });
            });
        };
        
        function _buscarPortos() {
            $http.get("http://localhost:8080/mapadebordo/api/portos").then(function(response) {
                viagemVm.portos = response.data;
                setTimeout(function() {
                   $("#ViagemPortoOrigem, #ViagemPortoDestino").material_select(); 
                });                
            });
        };
        
        function _init() {
            _buscarEmbarcacoes();
            _buscarPortos();
            $('.datepicker').pickadate({
                selectMonths: true,
                selectYears: 2,
                onSet: function( arg ){
                    if ( 'select' in arg ){ //prevent closing on selecting month/year
                        this.close();
                    }
                },
                labelMonthNext: 'Próximo mês',
                labelMonthPrev: 'Mês anterior',
                labelMonthSelect: 'Selecione um mês',
                labelYearSelect: 'Selecione um ano',
                monthsFull: [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
                monthsShort: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
                weekdaysFull: [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado' ],
                weekdaysShort: [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
                weekdaysLetter: [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
                today: 'Hoje',
                clear: 'Limpar',
                close: 'Fechar',                
                format: 'dd/mm/yyyy'
            });
        }
        
        viagemVm.salvar = function(viagem) {
            console.log(viagem);
        };
        
        _init();
    });
})();    