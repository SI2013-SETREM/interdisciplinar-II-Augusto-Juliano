var app = angular.module('sotosApp', []);
app.controller("sotosController", function ($scope, $compile) {
    $scope.requestPage = function (page, activeTab, model) {
        $("#content-page").load("view/" + page + ".html", function () {
            if (model) {
                $scope.model = model;
            } else {
                $scope.model = {};
            }
            $scope.$parent.activetab = activeTab;
            $compile($("#content-page"))($scope);
        });
    };
});

app.controller("drCorController", function ($scope, $http) {
    $scope.drCorLst = [];
    $scope.sortType = "cor_descricao";
    $scope.sortReverse = false;
    $scope.search = "";
    $scope.drCor = $scope.$parent.model;

    $scope.loadDrCorLst = function () {
        $http.get("ws/DrCorController/findAll", {method: "GET"}).then(function (response) {
            $scope.drCorLst = response.data;
        });
    };

    $scope.delete = function (drCor) {
        bootbox.confirm("Deseja realmente excluir o registro?", function (ok) {
            if (ok) {
                $http({
                    method: "GET",
                    url: "ws/DrCorController/delete",
                    params: {
                        json: drCor
                    }
                }).then(function (response) {
                    bootbox.alert("Registro excluído com Sucesso!", function () {
                        $scope.loadDrCorLst();
                    });
                });
            }
        });
    };

    $scope.save = function (drCor) {
        if (drCor.cor_codigo === undefined) {
            $scope.insert(drCor);
        } else {
            $scope.update(drCor);
        }
    };

    $scope.insert = function (drCor) {
        $http({
            method: "GET",
            url: "ws/DrCorController/insert",
            params: {
                json: drCor
            }
        }).then(function (response) {
            bootbox.alert("Registro inserido com Sucesso!", function () {
                $scope.requestPage('lst/drCorLst');
            });
        });
    };

    $scope.update = function (drCor) {
        $http({
            method: "GET",
            url: "ws/DrCorController/update",
            params: {
                json: drCor
            }
        }).then(function (response) {
            bootbox.alert("Registro alterado com Sucesso!", function () {
                $scope.requestPage('lst/drCorLst');
            });
        });
    };

    $scope.loadDrCorLst();
});