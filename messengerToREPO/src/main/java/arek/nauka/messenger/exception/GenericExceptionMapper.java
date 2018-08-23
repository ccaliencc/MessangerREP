package arek.nauka.messenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import arek.nauka.messenger.model.ErrorMessage;

@Provider 
public class GenericExceptionMapper implements ExceptionMapper<Throwable>
{
	@Override
	public Response toResponse(Throwable ex)
	{
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "Błąd Generic Exception");
		return Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR)
						.type(MediaType.APPLICATION_JSON)
						.entity(errorMessage)
						.build();
	}
}
