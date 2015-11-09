var app = angular.module("sotosMainApp", [])
        .controller("sotosApp", function ($scope, $compile) {
            $scope.requestPage = function (page) {
                $("#content-page").load("view/lst/" + page + ".html");
                $compile($("#content-page"))($scope);
            };
        });