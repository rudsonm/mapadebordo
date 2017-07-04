(function() {
    angular.module("MapaDeBordo").controller("ViagemController", function($http) {
        var viagemVm = this;
        viagemVm.viagem = {lances: []};
        viagemVm.template = 'lista';
        
        viagemVm.salvar = function(viagem) {
            viagem.dataSaida = converterData(viagem.dataSaida);
            viagem.dataChegada = converterData(viagem.dataChegada);
            $http.post("http://localhost:8080/mapadebordo/api/viagens", viagem).then(function() {
                window.location.href = "!#/viagens";
            });
        };
        
        viagemVm.salvarLance = function(lance) {
            viagemVm.viagem.lances.push(lance);
            viagemVm.lance = {capturas: []};
            viagemVm.template = 'lista';
        };
        
        viagemVm.adicionarCaptura = function(lance) {
            lance.capturas.push({});
            setTimeout(function() {
                $("#CapturaEspecie"+(lance.capturas.length-1)).material_select();
            });
        };
        
        function _buscarViagens() {
            $http.get("http://localhost:8080/mapadebordo/api/viagens").then(function(response) {
                viagemVm.viagens = response.data;
            });
        };
        
        function _buscarViagem(id) {
            $http.get("http://localhost:8080/mapadebordo/api/viagens/"+id).then(function(response) {
                viagemVm.viagem = response.data;
            });
        };
        
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
        
        function _buscarEspecies() {
            $http.get("http://localhost:8080/mapadebordo/api/especies").then(function(response) {
                viagemVm.especies = response.data;
                setTimeout(function() {
                    $("#CapturaEspecie").material_select();
                });
            });
        }
        
        function converterData(data) {
            var tmp = data.split("/");
            return tmp[2] + "-" + tmp[1] + "-" + tmp[0];
        }
        
        function _init() {
            _buscarEmbarcacoes();
            _buscarEspecies();
            _buscarPortos();
            _buscarViagens();
            $(document).ready(function() {
               $('.datepicker').pickadate({
                    selectMonths: true,
                    selectYears: 2,
                    onSet: function( arg ){
                        if ( 'select' in arg ){
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
                $('ul.tabs').tabs(); 
            });                
        }                
        
        _init();
    });
})();    