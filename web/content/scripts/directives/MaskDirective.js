angular.module("MapaDeBordo").directive("mask", function () {
    return {
        restrict: "A",
        link: function (scope, element, attributes) {
            var attr = element.attr('mask');
            
            switch (attr) {
                case 'telefone':
                    $(element).mask('(99) 99999-9999');
                break;
            
            
            }
            console.log(attributes, element);
        }
    }
});