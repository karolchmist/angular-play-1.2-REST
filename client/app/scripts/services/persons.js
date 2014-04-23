'use strict';

angular.module('hellongApp')
  .service('Persons', function Persons($resource) {
        return $resource('http://localhost:7000/persons/:id');
  });
