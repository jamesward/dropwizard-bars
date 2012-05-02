package com.jamesward;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class BarResource {

  private static List<Bar> bars = new ArrayList<Bar>();

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String index() {
    String contentUrl = (System.getenv("CONTENT_URL") != null) ? System.getenv("CONTENT_URL") : "";

    return " <!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "  <title>dropwizard-bars</title>\n" +
            "  <script type=\"text/javascript\" src=\"" + contentUrl + "/public/javascripts/jquery.min.js\"></script>\n" +
            "  <script type=\"text/javascript\" src=\"" + contentUrl + "/content/index.js\"></script>\n" +
            "</head>\n" +
            "<body>\n" +
            "</body>\n" +
            "</html>";
  }

  @GET
  @Path("bars")
  public List<Bar> listBars() {
    return bars;
  }

  @POST
  @Path("bars")
  @Consumes(MediaType.APPLICATION_JSON)
  public Bar addBar(final Bar bar) {
    bar.id = UUID.randomUUID().toString();
    bars.add(bar);
    return bar;
  }

}