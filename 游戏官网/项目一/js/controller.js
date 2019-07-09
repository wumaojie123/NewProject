(function (angular) {
    var app = angular.module('app');

    app.controller('baseController', ['$scope', function ($scope) {
        $scope.title = '坚果游戏';
        $scope.type = store.get('type') != undefined ? store.get('type') :'index';
        $scope.change = function (type) {
            $scope.type = type;
            store.set('type',type);

        }
    }])

    app.controller('indexController', ['$scope', function ($scope) {


    }])

})(angular);