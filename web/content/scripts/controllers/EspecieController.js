(function() {
    angular.module("MapaDeBordo").controller("EspecieController", function($http) {
        var especieVm = this;
        
        $http.get("http://localhost:8080/mapadebordo/api/especies")
                .then(function(response) {
            console.log(response);
            especieVm.especies = response.data;
        });
        
        especieVm.salvar = function(especie) {
            $http.post("http://localhost:8080/mapadebordo/api/especies", especie).then(function(response) {
                especieVm.especies.push(response.data);
                window.location.href = "#!/especies";
            });
        };
        
        especieVm.remover = function(especie) {
            $http.delete("http://localhost:8080/mapadebordo/api/especies/"+especie.id);
            especieVm.especies.filter(function(e, i) {
                if(e.id === especie.id)
                    especieVm.especies.splice(i, 1);
            });
            
        };
    });
})();    