JAVA EE / JAX-RS - Labb 1 on Main branch
JAVA EE / JAX-RS - Labb 2 on Labb2 branch

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


@GET

_Get Subject including Teacher and Students who have that subject_

http://localhost:8080/student-management-system/api/v1/subjects
