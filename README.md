nstall Node,npm
sudo add-apt-repository ppa:chris-lea/node.js
sudo apt-get update
sudo apt-get install nodejs
sudo apt-get install npm


Install Yeoman
#scaffolding - not needed if generator
sudo npm install -g yo
#dependency management
sudo npm install -g bower
#tasks
sudo npm install -g grunt-cli

sudo npm install -g generator-angular

mkdir hello_ng
do tworzenia projektu
yo angular hello_ng

grunt 

#Test?
http://phantomjs.org/download.html
npm install -g karma@canary phantomjs cd 
npm install karma-jasmine --save-dev
npm install phantomjs karma-phantomjs-launcher
npm install karma-firefox-launcher

HelloNG
git init
#echo …>>.gitignore
git add .
git commit -m “Data in controller”


git clone https://github.com/karolchmist/angular-play-1.2-REST

#Server Play
play clean
play deps --sync
play eclipsify
play run

Testy link
http://jasmine.github.io/


Templating
Expressions (2+2, ‘abc’, 2 > 3) ✓
Scope ($scope.name, {{ name }}) ✓
Show ✓
Two-way binding ✓
Events (ng-click) ✓
Repeaters ✓
Filtering (filter, number, currency, orderBy) ✓
Form (add/delete/edit, form.$dirty) ✓
Routing (yo angular:route edit, $routeParams)✓
Resources✓
yo angular:service Persons
Directives (local scope, ACE, @string, =model, &expr
https://code.angularjs.org/1.1.5/docs/guide/directive

