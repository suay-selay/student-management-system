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
        return Response.ok(foundStudent).status(Response.Status.FOUND).build();
    }

    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudent = studentService.getAllStudents();
        String errorMessage = "{\"There are no students in the database yet!\"}";
        if (foundStudent.isEmpty()) {
            throw new StudentDoesntExistException(errorMessage);
        }
        return Response.ok(foundStudent).status(Response.Status.FOUND).build();
    }

    @Path("getbylastname")
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName) {
        List<Student> foundStudent = studentService.findStudentByLastName(lastName);
        if (foundStudent.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"Student with lastname " + lastName + " was not found in database.\"}").build());
        }
        return Response.ok(foundStudent).status(Response.Status.FOUND).build();
    }

    //Update
    @Path("{id}")
    @PATCH
    public Response updateStudent(@PathParam("id") Long id, @QueryParam("lastName") String lastName) {
        String errorMessage = "{\"There is no student with ID: " + id + "!\"}";
        if (studentService.findStudentById(id)==null){
            throw new StudentDoesntExistException(errorMessage);
        }
        Student updatedStudent = studentService.updateStudent(id, lastName);
            return Response.ok(updatedStudent).status(Response.Status.OK).build();
    }

    //Delete
    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        String errorMessage = "{\"There is no student with Id: " + id + "!\"}";
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            studentService.deleteStudent(id);
            return Response.ok().entity("{\"Student with Id: " + id + " have been successfully deleted!\"}")
                    .status(Response.Status.NO_CONTENT).build();
        } else {
            throw new StudentDoesntExistException(errorMessage);
        }
    }

}
