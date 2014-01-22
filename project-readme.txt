====================================
Chef Application deployment project:
====================================
We have a goal to be able to create a real world sample application that will 
work its way through our evolving chef deployment work flow. The goal is to 
become proficient in the chef deployment process using a very simple application.

The process of a chef deployment is to include continuous integration, deployment 
and testing. To accomplish this a test application must be built and saved into our
deployment process. Our test application will consist of the following pieces:

1) A mysql data base. This DB will contain one table consisting of a small set of
known data. A chef server will be provisioned with this database and it will be 
secured and loaded by the chef-client and a supporting recipe.

2) A webapp that uses the mysql data. A simple HTML form/page will be used to show
data from the mysql database. This will be a simple table of data and a "add/remove"
set of buttons. HTML elements will be given name attributes in order to facilitate
easy testing with selenium.

===============
Recipes needed:
===============
Following the above goals two recipes will be needed. The first one will be to build
the web server, create and load the database. The second one will create a web server
and load the webapp/war file into the web servers file structure. Additional 
configuration files that help link the webapp to the mysql server will be needed.

Questions / Thing on my plate:

How do I add an sql load file and run it with chef.
How do I know the name of the mysql server in order to put it into web configuration.

======================
Web Application Facts:
======================
The application part of the project is bundled as a war file. It has the following
rest endpoints that can be used for testing:

1) GET /rest/stock/i-say/{msg}
	returns the string "I say: <msg>" where <msg>  was passed in on the URL. 
	this is a simple DBless check of the web service layer.
	
2) GET /rest/stock/
    returns a full list of stock objects
	
3) GET /rest/stock/{code}
    returns a specific stock object given a code (which is an index)

4) POST /rest/stock/{id}
   CONTENT-TYPE JSON
   { name: "name", code: "code" }
   updates an object based on known DB id.
   
5) PUT /rest/stock/
   CONTENT-TYPE JSON
   { name: "name", code: "code" }
   creates an object.

6) DELETE /rest/stock/{id}
   deletes an object based on known DB id.   

Sample URLs to localhost:

http://localhost:8080/SimpleApp-1.0-SNAPSHOT/test.html
http://localhost:8080/SimpleApp-1.0-SNAPSHOT/rest/stock/
http://localhost:8080/SimpleApp-1.0-SNAPSHOT/rest/stock/code/ABBA   
   
===============   
Database Facts:
===============




