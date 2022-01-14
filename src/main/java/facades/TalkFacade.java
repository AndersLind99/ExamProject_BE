package facades;

import dtos.TalkDTO;
import entities.Talk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TalkFacade {

    public TalkFacade() {
    }

    private static TalkFacade instance;
    private static EntityManagerFactory emf;

    public static TalkFacade getTalkFacade(EntityManagerFactory _emf) {
        if (instance == null) {

            emf = _emf;
            instance = new TalkFacade();

        }
        return instance;


    }

    public TalkDTO updateTalk(TalkDTO talkDTO) {
        EntityManager em = emf.createEntityManager();

        Talk talk = em.find(Talk.class, talkDTO.getId());
        talk.setDuration(talkDTO.getDuration());
        talk.setTopic(talkDTO.getTopic());

        try {
            em.getTransaction().begin();
            em.merge(talk);
            em.getTransaction().commit();


        } finally {
            em.close();
        }

        return talkDTO;
    }

    public void createTalk(TalkDTO talkDTO) {
        EntityManager em = emf.createEntityManager();
        Talk talk = new Talk(talkDTO);

        try {
            em.getTransaction().begin();
            em.persist(talk);
            em.getTransaction().commit();
        } finally {
            em.close();
        }


    }

}
