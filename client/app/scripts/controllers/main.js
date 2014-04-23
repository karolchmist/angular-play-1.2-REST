'use strict';

angular.module('hellongApp')
  .controller('MainCtrl', ['$scope', 'Persons', function ($scope, Persons) {
        $scope.persons = Persons.query();

        $scope.edit = function(person) {
            $scope.person = person;
        };

        $scope.save = function() {
            if($scope.person.$save) {
                $scope.person.$save(function(data){
                    $scope.person = null;
                });
            } else {
                Persons.save($scope.person, function(data) {
                    $scope.persons.push(data);
                    $scope.person = null;
                });
            }
        };

        $scope.delete = function(person, $index) {
            person.$delete({id:person.id}, function() {
                $scope.persons.splice($index, 1);
            });
        };
    }]);
