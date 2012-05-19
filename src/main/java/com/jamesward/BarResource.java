package com.jamesward;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Produces(MediaType.APPLICATION_JSON)
@Path("/bars")
public class BarResource {

    private static List<Bar> bars = new ArrayList<Bar>();

    @GET
    public List<Bar> listBars() {
        return bars;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Bar addBar(final Bar bar) {
        bar.id = UUID.randomUUID().toString();
        bars.add(bar);
        return bar;
    }

}