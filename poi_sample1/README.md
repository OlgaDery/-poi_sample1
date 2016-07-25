# poi_app
Small and simplified part of the YourNaviGuide web application.
Used technologies: Maven, Apache Derby database, JPA, Servlet, EJB, Ajax, Google Maps API. 
It allows user to start the application, to upload some sample points of interest from the text file to the database and show them on Google Map filtering by certain parameters.

## Requirements:
- Eclipse Mars;
- WildFly 9.0.2 or 10.0.0;
- Apache Derby 10.12.1.1.

## How to deploy:
- Clone the project on your machine.
- Extract it and import in Eclipse as an existing Maven project.
- Remove _standalone.xml_ from the project files and put it into the folder with the configuration files of the web server you intend to use.
- The text file with the sample points - _poi.txt_ - is in the _WebContent_ directory of the project. If you want, save it in a different folder.
- Configure this web server in Eclipse using the _standalone.xml_ you have saved.
- Start the Derby server on your mashine.
- Create a new database connection in your workspace for Derby. Create a new database called _inventory_. Connect to this database.
- Add the WAR file to the list of deployements of your web server and run the web server. Then, full publish this file. The table in the database will be created automatically.
- In the browser, go to _http://localhost:8080/poi_app/map_. To upload the sample points to the database, go to the _admin_ page, in the input box enter the path
to the _poi.txt_ file and click the UPLOAD button. If points have uploaded successfully, you will see the message under the header.
- Now you may go to the _map_ page and test the filters.

 
