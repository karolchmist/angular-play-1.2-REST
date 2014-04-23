'use strict';

describe('Controller: MainCtrl', function () {

  // load the controller's module
  beforeEach(module('hellongApp'));

  var MainCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MainCtrl = $controller('MainCtrl', {
      $scope: scope
    });
  }));

  it('should put a person in edition', function () {
      var person = {name: "Karol", age: 40};
      scope.edit(person);
    expect(scope.person).toBe(person);
  });
});
