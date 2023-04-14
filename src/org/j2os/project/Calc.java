package org.j2os.project;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/calc1")
public class Calc {
    @Path("/sum1")
    @Produces("text/plain")
    @GET
    public String sum (@QueryParam("p1") String x,@QueryParam("p2") String y)
    {
        int result = Integer.parseInt(x)+Integer.parseInt(y);
        return String.valueOf(result);
    }
    @Path("/minus1")
    @Produces("text/plain")
    @GET
    public String minus (@QueryParam("p1") String x,@QueryParam("p2") String y)
    {
        int result = Integer.parseInt(x)-Integer.parseInt(y);
        return String.valueOf(result);
    }
}
