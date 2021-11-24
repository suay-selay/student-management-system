# JAVA EE / JAX-RS - Labb 1 on Main branch

● CRUD-funktionalitet ska implementeras (Create, Read, Update, Delete)
● Data om en student ska kunna hämtas med efternamn som en Query Parameter
● När en ny student ska läggas till, är alla fält obligatoriska utom telefonnummer
● Anropen ska returnera meningsfulla Response Codes
● Skapa minst en egen exception
● Felhantering ska finnas för varje CRUD-metod, och felmeddelande ska returneras i JSON-format

ENDPOINTS (CRUD)

**_Create_** 

@POST

http://localhost:8080/student-management-system/api/v1/students 

JSON body:

{
"firstName" : "Sona",
"lastName" : "Rahimova",
"email" : "sr@gmail.com",
"phoneNumber": "1234567899"
}


_**Read**_

@GET

_1. Get Student by ID_
http://localhost:8080/student-management-system/api/v1/students/1

_2. Get all Students_
http://localhost:8080/student-management-system/api/v1/students 

_3. Get Student by lastname_
http://localhost:8080/student-management-system/api/v1/students/getbylastname?lastName=Rahimova

_**Update**_

@Patch

http://localhost:8080/student-management-system/api/v1/students/1?lastName=Mirzali

JSON body response after Patch method:

{
"email": "sr@gmail.com",
"firstName": "Sona",
"id": 1,
"lastName": "Mirzali",
"phoneNumber": "1234567899"
}

_**Delete_**

@DELETE

http://localhost:8080/student-management-system/api/v1/students/1
