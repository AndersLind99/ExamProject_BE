package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ConferenceDTO;
import dtos.SpeakerDTO;
import dtos.TalkDTO;
import entities.Speaker;
import facades.SpeakerFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("speaker")
public class SpeakerResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final SpeakerFacade FACADE = SpeakerFacade.getSpeakerFacade(EMF);

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
        List<SpeakerDTO> rns = FACADE.getAll();
        return Response.ok().entity(GSON.toJson(rns)).build();

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTalksBySpeaker(@PathParam("id") int id) {

        List<TalkDTO> talkDTOList = FACADE.getAllTalks(id);

        return Response.ok().entity(GSON.toJson(talkDTOList)).build();
    }

    @POST
    @Path("create")
    @RolesAllowed("admin")
    public Response createSpeaker(String body) {
        SpeakerDTO speakerDTO = GSON.fromJson(body, SpeakerDTO.class);
        FACADE.createSpeaker(speakerDTO);

        return Response.ok().entity(speakerDTO).build();
    }

    @PUT
    @Path("update")
    @RolesAllowed("admin")
    public Response update(String body) {

        SpeakerDTO speakerDTO = GSON.fromJson(body, SpeakerDTO.class);
        FACADE.updateSpeaker(speakerDTO);


        return Response.ok().entity(speakerDTO).build();
    }


}
