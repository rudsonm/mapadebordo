(function() {
    angular.module("MapaDeBordo").controller("EmbarcacaoController", function() {
        var embarcacaoVm = this;
        
        embarcacaoVm.salvar = salvar;
        
        function salvar(embarcacao) {
            console.log(embarcacao);
        }
                
    });
})();    