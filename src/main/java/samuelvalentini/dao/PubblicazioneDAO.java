package samuelvalentini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import samuelvalentini.entity.pubblicazione.Pubblicazione;
import samuelvalentini.exceptions.NotFoundException;
import samuelvalentini.exceptions.NotSavedException;

import java.util.UUID;

public class PubblicazioneDAO {
    private final EntityManager entityManager;

    public PubblicazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Pubblicazione newPubblicazione) {
        try {
            EntityTransaction transaction = this.entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newPubblicazione);
            transaction.commit();
            System.out.println("La pubblicazione " + newPubblicazione.getTitolo() + " è stata salvata con successo!");
        } catch (Exception e) {
            throw new NotSavedException(newPubblicazione);
        }

    }

    public Pubblicazione getById(UUID idPubblicazione) {
        Pubblicazione pubblicazione = entityManager.find(Pubblicazione.class, idPubblicazione);
        if (pubblicazione == null) throw new NotFoundException(idPubblicazione);
        return pubblicazione;

    }

    public void deleteById(UUID idPubblicazione) {
        Pubblicazione pubblicazione = this.getById(idPubblicazione);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(pubblicazione);
        transaction.commit();
        System.out.println("La pubblicazione " + pubblicazione.getTitolo() + " è stato eliminato con successo!");

    }
}
