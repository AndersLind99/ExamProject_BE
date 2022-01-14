package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ConferenceDTO;
import dtos.TalkDTO;
import facades.ConferenceFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("conference")
public class ConferenceResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final ConferenceFacade FACADE = ConferenceFacade.getConferenceFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {

        return "{\"msg\":\"Hello World\"}";

    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<ConferenceDTO> rns = FACADE.getAll();
        return Response.ok().entity(GSON.toJson(rns)).build();

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTalksByConference(@PathParam("id") int id) {

        List<TalkDTO> talkDTOList = FACADE.getAllTalks(id);

        return Response.ok().entity(GSON.toJson(talkDTOList)).build();
    }

    @POST
    @Path("create")
    @RolesAllowed("admin")
    public Response createConference(String body) {
        ConferenceDTO conferenceDTO = GSON.fromJson(body, ConferenceDTO.class);
        FACADE.createConference(conferenceDTO);

        return Response.ok().entity(conferenceDTO).build();
    }

    @PUT
    @Path("update")
    @RolesAllowed("admin")
    public Response update (String body){
        ConferenceDTO conferenceDTO = GSON.fromJson(body,ConferenceDTO.class);
        FACADE.updateConference(conferenceDTO);



        return Response.ok().entity(conferenceDTO).build();
    }


}
