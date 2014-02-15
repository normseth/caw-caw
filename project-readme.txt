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
The application part of the project is bundled as a war file.
I ripped this code of from a simple DB application that I found
online for persisting stock quotes. It uses hibernate so it should
hook up to other DBs easily.

It has the following rest endpoints that can be used for testing:

1) GET http://localhost:8080/SimpleApp/stock?name=<name>
    returns a JSON for one item.
	
2) GET http://localhost:8080/SimpleApp/stock
    returns a full list of stock objects
	
3) POST http://localhost:8080/SimpleApp/stock
   parameters: { name: "name", code: "code" }
   updates or creates an item based on DB name.
   
4) POST http://localhost:8080/SimpleApp/stock
   parameters: { name: "name" }
   deletes an item based on DB name.
   
The UI for the super simple app is here:   
http://localhost:8080/SimpleApp/test.html

This HTML page has 2 text boxes and a submit button. When simething is entered, and
submitted and ajax call is made to the web service. The web service will persist the
changes into the DB. The page then reloads and gets the fresh list of items from
the server.

To adjust the DB parameters, one can edit the parameters after deployment into tomcat, or
unpack & repack the war. In windows with WinZip, one can edit the file without unpacking it.

The database.properties file contains the connection parameters and this can be found at:
SimpleApp/WEB-INF/classes/properties/database.properties
   
===============   
Database Facts:
===============

See the init-database file - this contains the script that will create the DB, the
tables and insert a few rows. It also has some lines to grant rights to read data
from a remote connection.




