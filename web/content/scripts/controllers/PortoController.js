(function() {
    angular.module("MapaDeBordo").controller("PortoController", function() {
        var portoVm = this;
        portoVm.portos = [
            {
                nome: "Porto blabla",
                anoFundacao: 2000,
                administracao: 'PUBLICO'
            }
        ];
    });
})();    