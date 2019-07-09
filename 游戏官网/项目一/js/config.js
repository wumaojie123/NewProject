(function (angular) {
    var app = angular.module('app');
    app.config(['$routeProvider',function ($routeProvider) {
        $routeProvider.when('/jianguo/index',{
            templateUrl:'index_tpl.html',
            controller:'indexController'
        }).when('/jianguo/game',{
            templateUrl:'game.html',
            controller:'indexController'
        }).when('/jianguo/callme',{
            templateUrl:'callme.html',
            controller:'indexController'
        }).when('/jianguo/about',{
            templateUrl:'about.html',
            controller:'indexController'
        }).when('/jianguo/zhuanti',{
            templateUrl:'zhuanti.html',
            controller:'indexController'
        }).otherwise({
            redirectTo:'/jianguo/index'
        })
    }])
})(angular);