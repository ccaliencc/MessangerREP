package arek.nauka.messenger.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import arek.nauka.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

	@Override
	public Response toResponse(DataNotFoundException ex)
	{
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "Dokumentacja");
		return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND)
						.entity(errorMessage)
						.build();
	}

}
