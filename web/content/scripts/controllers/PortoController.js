(function() {
    angular.module("MapaDeBordo").controller("PortoController", function($http) {
        var portoVm = this;          

        $http.get("http://localhost:8080/mapadebordo/api/portos").then(function(response) {
            console.log(response);
            portoVm.portos = response.data;
        });
        
        portoVm.salvar = function(porto) {
            $http.post("http://localhost:8080/mapadebordo/api/portos", porto).then(function(response) {
                portoVm.portos.push(response.data);
                window.location.href = "#!/portos";
            });
        };
        
        portoVm.remover = function(porto) {
            $http.delete("http://localhost:8080/mapadebordo/api/portos/"+porto.id).then(function(response) {
                portoVm.porto.filter(function(e, i) {
                    if(e.id === porto.id)
                        portoVm.porto.splice(i, 1);
                });
            });
            
        };

        $(document).ready(function() {
            $("#PortoAdministracao").material_select();
        });

    });
})();    