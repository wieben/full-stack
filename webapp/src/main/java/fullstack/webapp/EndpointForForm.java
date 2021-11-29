package fullstack.webapp;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("endpointforform")
public class EndpointForForm
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    @Path("callforform")
    public Response someCall(@FormParam("label") String label) throws JsonProcessingException
    {
        ResponseData responseData = new ResponseData("you posted " + label);
        String entity = OBJECT_MAPPER.writeValueAsString(responseData);
        return Response.ok(entity).build();
    }

    @JsonAutoDetect
    private static class ResponseData
    {
        public final String label;

        public ResponseData(String label)
        {
            this.label = label;
        }
    }
}
