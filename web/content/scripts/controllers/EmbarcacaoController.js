(function() {
    angular.module("MapaDeBordo").controller("EmbarcacaoController", function() {
        var embarcacaoVm = this;
        
       $http.get("http://localhost:8080/mapadebordo/api/especies").then(function(response) {
            especieVm.especies = response.data;
        });
        
        embarcacaoVm.salvar = function(embarcacao) {
            $http.post("http://localhost:8080/mapadebordo/api/embarcacoes", embarcacao).then(function() {
                window.location.href = "#!/embarcacoes";
            });
        };
        
        embarcacaoVm.remover = function(embarcacao) {
            $http.delete("http://localhost:8080/mapadebordo/api/embarcacoes/"+embarcacao.id);
            embarcacaoVm.embarcacao.filter(function(e, i) {
                if(e.id === embarcacao.id)
                    embarcacaoVm.embarcacoes.splice(i, 1);
            });
            
        };
                
    });
})();    