'use strict';

angular.module('hellongApp')
  .controller('MainCtrl', ['$scope', function ($scope) {
    $scope.people = [{
        name : "Karol",
        age : 31
    },{
        name : "Lukasz",
        age : 32
    }];

    $scope.currentPerson = [];

    $scope.delete = function(person, $index) {
        $scope.people.splice(start, $index);
    };

    $scope.edit = function(person) {
        $scope.currentPerson = person;
    };

    $scope.add = function(person) {
        $scope.people.push(person);
    } ;

  }]);
