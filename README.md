# JAVA EE / JAX-RS - Labb 1 on Main branch
# JAVA EE / JAX-RS - Labb 2 on Labb2 branch

● Lägg till två entiteter, Subject (ämne) och Teacher (lärare).

● En student ska kunna ha flera ämnen.

● Ett ämne har flera studenter och en lärare.

● En lärare ska kunna ha flera ämnen.

● Det ska finnas möjlighet att via en endpoint få fullständig information om ett ämne
(det vill säga en lista på deltagande studenter, samt vem som är lärare).

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
