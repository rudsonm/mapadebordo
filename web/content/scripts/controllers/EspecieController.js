(function() {
    angular.module("MapaDeBordo").controller("EspecieController", function($http) {
        var especieVm = this;
        
        $http.get("http://localhost:8080/mapadebordo/api/especies").then(function(response) {
            especieVm.especies = response.data;
        });
        
        especieVm.salvar = function(especie) {
            especieVm.files = [];
            var files = document.getElementById("EspecieImagens").files;
            for (var i = 0; i < files.length; i++)  
                especieVm.files.push(_serializarImagem(files[i]));
            return console.log(especieVm.files);
            $http.post("http://localhost:8080/mapadebordo/api/especies", especie).then(function(response) {
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
        
        function _serializarImagem(imagem) {
            var reader = new FileReader();
            reader.addEventListener("load", function () {
                preview.src = reader.result;
            }, false);
            reader.readAsDataURL(imagem);
            return reader;
        }
    });
})();    