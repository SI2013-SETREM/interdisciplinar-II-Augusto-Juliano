var app = angular.module("drCorApp", []).controller("drCorController", function ($scope, $http) {
    $scope.drCorLst = [];
    $scope.sortType = "cor_descricao";
    $scope.sortReverse = false;
    $scope.search = "";

    $scope.loadDrCorLst = function () {
        $http.get("../../ws/DrCorController/findAll", {method: "GET"}).then(function (response) {
            $scope.drCorLst = response.data;
        });
    };

    $scope.delete = function (drCor) {
        debugger;
        $http({
            method: "GET",
            url: "../../ws/DrCorController/delete",
            params : {
                json: drCor
            }
        }).then(function (response) {
            $scope.drCorLst = response.data;
        });
    };

    $scope.loadDrCorLst();
});