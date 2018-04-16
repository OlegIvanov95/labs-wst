package com.wst.lab1;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ThrottlingExceptionMapper implements ExceptionMapper<ThrottlingException>
{
    @Override public Response toResponse(ThrottlingException e)
    { return Response.status(422).entity(e.getMessage()).build(); }
}
