package se.iths.rest;

import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("student")
public class StudentRest {

    @Inject
    StudentService studentService;


}
