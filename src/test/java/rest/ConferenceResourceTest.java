package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Conference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


class ConferenceResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static Conference c1, c2;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    private static String securityToken;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);

    }

    @BeforeAll
    public static void setUpClass() {
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        httpServer = startServer();


        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;


    }

    @AfterAll
    public static void closeTestServer() {
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();


    }

    @BeforeEach
    void setup() {
        EntityManager em = emf.createEntityManager();
        c1 = new Conference("Test", "Rønne", "500", "idag", "12:30");
        c2 = new Conference("Test2", "Rønne2", "5002", "idag2", "13:00");

        try {
            em.getTransaction().begin();
            em.createNamedQuery("Conference.deleteAllRows").executeUpdate();
            em.persist(c1);
            em.persist(c2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Test
    public void testServerIsUp() {
        given().when().get("/conference").then().statusCode(200);


    }

    @Test
    void getAll() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/conference/all")
                .then()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .assertThat()
                .body("size()", is(2));

    }
}