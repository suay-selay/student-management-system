package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NonvalidInputException extends WebApplicationException {

    public NonvalidInputException(String message){
    super(Response.status(Response.Status.NOT_ACCEPTABLE)
            .entity(message).type(MediaType.APPLICATION_JSON).build());
    }
}
