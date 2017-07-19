# BigBoxWebApplication
<p> This project is the 6.0 version or iteration of BigBox Application version 5.0. This is a Dynamic Web application project that uses Maven to build and is deployed to Heroku.
It consists of servlet, jsps and html pages which creates home page, BigBox application page where user can view list of stores, divisions,users,registration and login page.
  This application consists of User, Division, Store and Store Sales classes stored into their respective packages.It implements the DAO Factory Pattern and stores and gets the data from MYSQL Database. It also includes PLSQL connector and other Jar files and 
 SQL Script in bigbox.SQL package.</p>
 <b><u>Content Folders</u></b>
 <p> WebContent:- Contains JSP, HTML, CSS and Images files.</p>
 <p>SRC:- This folder contains all the Packages for this application.It includes following packages and class files that contains inside it. <ul>
                           <li>bigbox.presentation:- contains bigbox.java application which is the presentation or view of the project in console</li>
                           <li>bigbox.business:- This package contains POJO or business class of the application. It inclusdes Division, Facility, Store, StoreSales and user objects.</li>
                           <li>bigbox.controller:-This package contains Servelet classes. It includes AddStoreServlet,ContactServlet,DeleteServlet,DivisionServlet,HomeServlet,LoginServlet,RegistrationServlet,StoreSalesServlet and UserServlet.  </li>
                           <li>bigbox.db:- Contains all the files from db class that integrates with the database.It contains DAOFactory,DivisionDB,StoreDB,StoreSAlesDB,UserDB classes.</li>
                           <li>bigbox.divisions:- Contains all the reader, writer,DAO and constant files.</li>
                           <li>bigbox.stores:- Contains all the reader, writer,DAO and constant files.</li>
                           <li>bigbox.storesales:- Contains all the reader, writer,DAO and constant files.</li>
                           <li>bigbox.users:- Contains all the reader, writer,DAO and constant files.</li>
                           <li>bigbox.sql:-It contains the SQL scripts.</li>
                           <li>lib:- Lib folder inside WebContent/WEB_INF contains all the jar files.</li>
                           <li>pom.xml:- It is an XML file that contains information about the project and configuration details used by Maven to build the project. It contains default values for most projects.
                           <li>web.xml:- The web.xml Deployment Descriptor file describes how to deploy a web application in a servlet container such as Tomcat.  </li>
</li>
                           </ul>
                           </p>
<p>Since this project is a Dynamic web application User can access it online via URL and can register and login with the currently registered user name and password. You can see the home page with Welcome message and my resume and can access BigBox application from 
   menu and see the list of stores, divisions, users and many other features.</p>
   <p>Below are the pictures of how the web application looks as of today. It might look different in future and more features might be added.</p>
 
 
 
 
 
 
 
 
 ![applicationpage](https://user-images.githubusercontent.com/28536965/28386642-32de6be8-6c9a-11e7-8151-4d87e3e3e888.JPG)
![homepage](https://user-images.githubusercontent.com/28536965/28386644-32ef32b6-6c9a-11e7-84aa-59ddb88eaf26.JPG)
![listofallstores](https://user-images.githubusercontent.com/28536965/28386643-32ec7634-6c9a-11e7-9210-20b4faa53754.JPG)
![loginpage](https://user-images.githubusercontent.com/28536965/28386646-32f8e50e-6c9a-11e7-954c-b944787f1406.JPG)
![registrationpage](https://user-images.githubusercontent.com/28536965/28386645-32efac64-6c9a-11e7-9c5f-c3d59f3ee06a.JPG)

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 <dt><span class="simpleTagLabel"><b>Author:</b></span></dt>
 <dd>Rajiv Giri</dd>
