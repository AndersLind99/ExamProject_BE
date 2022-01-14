package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.SpeakerDTO;
import dtos.TalkDTO;
import facades.TalkFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("talk")
public class TalkResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final TalkFacade FACADE = TalkFacade.getTalkFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {

        return "{\"msg\":\"Hello World\"}";

    }

    @POST
    @Path("create")
    @RolesAllowed("admin")
    public Response createTalk(String body) {
        TalkDTO talkDTO = GSON.fromJson(body, TalkDTO.class);
        FACADE.createTalk(talkDTO);

        return Response.ok().entity(talkDTO).build();


    }

    @PUT
    @Path("update")
    @RolesAllowed("admin")
    public Response update(String body) {
        TalkDTO talkDTO = GSON.fromJson(body, TalkDTO.class);
        FACADE.updateTalk(talkDTO);

        return Response.ok().entity(talkDTO).build();
    }


}
