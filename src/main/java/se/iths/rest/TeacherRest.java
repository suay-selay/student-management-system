package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;


    //Create
    @Path("")
    @POST
    public Response createTeacher(Teacher teacher) {
        teacherService.createTeacher(teacher);
        return Response.ok(teacher).status(Response.Status.CREATED).build();
    }

    //Read
    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.findTeacherById(id);
        return Response.ok(foundTeacher).status(Response.Status.FOUND).build();
    }

    @Path("")
    @GET
    public Response getAllTeacher() {
        List<Teacher> foundTeacher = teacherService.getAllTeachers();
        return Response.ok(foundTeacher).status(Response.Status.FOUND).build();
    }

}