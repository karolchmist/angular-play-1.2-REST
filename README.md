#Description
Simple project containing REST client in angular and REST server in Play 1.2. May be used as an example of following features of angular:

* Templating  
* Expression (2+2, ‘abc’, 2 > 3)  
* Scope ($scope.name, {{ name }})  
* Two-way binding  
* Events (ng-click)  
* Repeaters  
* Filtering (filter, number, currency, orderBy)  
* Form (add/delete/edit, form.$dirty)  
* Routing
* Resources  

#Install Node and npm

sudo add-apt-repository ppa:chris-lea/node.js  
sudo apt-get update  
sudo apt-get install nodejs  
sudo apt-get install npm  

#Install Yeoman
##scaffolding - not needed if generator
sudo npm install -g yo
##dependency management
sudo npm install -g bower
##tasks
sudo npm install -g grunt-cli
##Angular generator
sudo npm install -g generator-angular

mkdir hello_ng && cd $_
yo angular hello_ng

grunt 

#Tests
http://phantomjs.org/download.html  
npm install -g karma@canary phantomjs cd   
npm install karma-jasmine --save-dev  
npm install phantomjs karma-phantomjs-launcher  
npm install karma-firefox-launcher  

#Server Play
play clean  
play deps --sync  
play eclipsify  
play run
