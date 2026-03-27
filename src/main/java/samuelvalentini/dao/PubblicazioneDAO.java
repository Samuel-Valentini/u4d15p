package samuelvalentini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import samuelvalentini.entity.pubblicazione.Pubblicazione;
import samuelvalentini.exceptions.NotFoundException;
import samuelvalentini.exceptions.NotSavedException;

import java.util.List;
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

    public Pubblicazione getByISBN(String isbn) {
        try {
            return entityManager.createQuery("SELECT p FROM Pubblicazione p WHERE p.codiceISBN = :isbn", Pubblicazione.class).setParameter("isbn", isbn).getSingleResult();

        } catch (NoResultException e) {
            System.out.println(isbn + "non trovato");
            return null;
        }

    }


    public void removeByISBN(String isbn) {
        Pubblicazione pubblicazione = this.getByISBN(isbn);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(pubblicazione);
        transaction.commit();
        System.out.println("La pubblicazione " + pubblicazione.getTitolo() + " è stato eliminato con successo!");

    }

    public List<Pubblicazione> getByYear(short anno) {
        try {
            return entityManager.createQuery("SELECT p FROM Pubblicazione p WHERE p.annoPubblicazione = :anno", Pubblicazione.class).setParameter("anno", anno).getResultList();

        } catch (NoResultException e) {
            System.out.println(anno + "nessuna pubblicazione trovata");
            return null;
        }

    }
}
