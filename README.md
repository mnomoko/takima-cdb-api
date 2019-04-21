# Computer Database
est. time: 3 days.

API Project

Your customer requested you to build a Computer DataBase application (codename: *CDB*).
He owns about 500+ computers made by different manufacturers (companies such as Apple, Acer, Asus...).

Ideally, each computer would contain the following: 
 - a name
 - the date when it was introduced
 - the date when it was discontinued 
 - a manufacturer

Obviously, for some reasons, the existing data is incomplete, and he requested that only the name should remain mandatory when adding a computer, 
the other fields being filled when possible.
Furthermore, if both are present, the discontinued date must be greater than the introduced one.

Both the computers and the companies can be modified: your customer want the application to add, delete, and update computers and companies.
The list of computers should also be pageable.

If the back-end works as expected, the customer also wants a front-end to create, delete, edit and list computers and companies. 

The only technical limitations are:
 - the back-end should use Java 
 - the database should use SQL (any DBMS)
 - The application should be designed as a client-server app, with a REST api in between.
 - the front-end should be written with Angular 2+
 - the back-end can run on linux

You are free to use any framework or design you want, if you think this is pertinent.
However, here are some tools that may worth considering: 
- Docker
- Spring / Spring boot

Your application is not required to be hosted online. 
For the time being, a test-purpose local setup is enough

Do not spend time on the front-end style. If you want, you can use the HTML & CSS templates provide to you.

