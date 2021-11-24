package se.iths.rest;

import se.iths.entity.Student;
import se.iths.exception.NonvalidInputException;
import se.iths.exception.StudentDoesntExistException;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;


    //Create
    @Path("")
    @POST
    public Response createStudent(Student student){
        //String errorMessage = "{\"A new student must have a firstname, a lastname and an email!\"}";
        if (student.getFirstName().isEmpty()) {
            throw new NonvalidInputException("{\"A new student must have a firstname!\"}");
        }
        if (student.getLastName().isEmpty()){
            throw new NonvalidInputException("{\"A new student must have a lastname!\"}");
        }
        if (student.getEmail().isEmpty()){
            throw new NonvalidInputException("{\"A new student must have an email!\"}");
        }
        studentService.createStudent(student);
        return Response.ok(student).status(Response.Status.CREATED).build();
    }


        //Read
    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        String errorMessage = "{\"Student with ID " + id + " was not found in database.\"}";
        if (foundStudent == null) {
            throw new StudentDoesntExistException(errorMessage);
        }
        return Response.ok(foundStudent).build();
    }

    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudent = studentService.getAllStudents();
        String errorMessage = "{\"There are no students in the database yet!\"}";
        if (foundStudent.isEmpty()) {
            throw new StudentDoesntExistException(errorMessage);
        }
        return Response.ok(foundStudent).build();
    }

    @Path("getbylastname")
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName) {
        List<Student> foundStudent = studentService.findStudentByLastName(lastName);
        if (foundStudent.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"Student with lastname " + lastName + " was not found in database.\"}").build());
        }
        return Response.ok(foundStudent).build();
    }


    //Update
    @Path("{id}")
    @PATCH
/*    public Response updateStudent(Student student){
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }*/

        public Response updateStudent(@PathParam("id") Long id, @QueryParam("lastName") String lastName) {
            Student updatedStudent = studentService.updateStudent(id, lastName);
            return Response.ok(updatedStudent).build();
    }
/*        String errorMessage = "{\"There is no student with given id!\"}";
        if (studentService.findStudentById(id)==null){
            throw new StudentDoesntExistException(errorMessage);
        }
        studentService.updateStudent(id, student);
        String message = "{\"Student have been successfully updated!\"}";
        return Response.ok(student).entity(message).build();
    }*/



/*    public Response updateStudent (Student student) {
        if (student.getLastName() == null){
            throw new StudentDoesntExistException("The student doesnt exist");
        } else {
        Student updatedStudent = studentService.updateStudent(student);
            return Response.ok(updatedStudent).build();
       }
    }*/


    //Delete
    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        String errorMessage = "{\"There is no student with Id: " + id + "!\"}";
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            studentService.deleteStudent(id);
            return Response.ok().entity("{\"Student with Id: " + id + " have been successfully deleted!\"}")
                    .build();
        } else {
            throw new StudentDoesntExistException(errorMessage);
        }
    }

}
