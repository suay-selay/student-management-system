package se.iths.rest;

import se.iths.entity.Student;
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
    @Path("new")
    @POST
    public Response createStudent(Student student){
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    //Read
    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " was not found in database.").type(MediaType.TEXT_PLAIN_TYPE).build());
        }
        return Response.ok(foundStudent).build();
    }

    @Path("getall")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudent = studentService.getAllStudents();
        return Response.ok(foundStudent).build();
    }

    @Path("getbylastname")
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName) {
        List<Student> foundStudent = studentService.findStudentByLastName(lastName);
        if (foundStudent.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with lastname " + lastName + " was not found in database.").build());
        }
        return Response.ok(foundStudent).build();
    }


    //Update
    @Path("update")
    @PUT
    public Response updateStudent(Student student){
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }


    //Delete
    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        studentService.deleteStudent(id);
        return Response.ok().build();
    }

}
