package utils;

import entities.Conference;
import entities.Speaker;
import entities.Talk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Populator {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Conference conference = new Conference("TedX", "Copenhagen", "2000", "15/08/22", "15:30");
        Speaker speaker = new Speaker("teddy", "Adventurerer", "Male");
        Talk talk = new Talk("Killing a dragon", "10min");

        speaker.addTalk(talk);
        conference.addTalkToList(talk);

        em.getTransaction().begin();
        em.persist(speaker);
        em.persist(conference);
        em.getTransaction().commit();
        em.close();


    }


}
