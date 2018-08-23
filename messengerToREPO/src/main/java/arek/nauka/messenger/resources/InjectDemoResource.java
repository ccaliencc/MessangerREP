package arek.nauka.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource
{
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam, //można dostać sie do matrix param zap omocą zapytania w pasku wyszkukania injectdemo/annotations;param=value
	                @HeaderParam("customHeaderValue") String header, //za pomocą headerparam można wpisywać swoje własne header parametry
	                @CookieParam("name") String cookie) //dostęp do coockie
	{
		return "Matrix param: " + matrixParam + "Header Param: " + header;
	}

	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers )
	{
		String path = uriInfo.getAbsolutePath().toString();
		String coockies = headers.getCookies().toString();
		return "Path:" + path + " Coockies: " + coockies;
	}

}
