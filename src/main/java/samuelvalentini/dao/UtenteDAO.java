package samuelvalentini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import samuelvalentini.entity.utente.Utente;
import samuelvalentini.exceptions.NotFoundException;
import samuelvalentini.exceptions.NotSavedException;

import java.util.UUID;

public class UtenteDAO {
    private final EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Utente newUtente) {
        try {
            EntityTransaction transaction = this.entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newUtente);
            transaction.commit();
            System.out.println("L'utente " + newUtente.getNomeUtente() + newUtente.getCognomeUtente() + " è stato salvato con successo con id " + newUtente.getIdUtente() + " e numero tessera: " + newUtente.getNumeroTesseraUtente());
        } catch (Exception e) {
            throw new NotSavedException(newUtente);
        }

    }

    public Utente getById(UUID idUtente) {
        Utente utente = entityManager.find(Utente.class, idUtente);
        if (utente == null) throw new NotFoundException(idUtente);
        return utente;

    }

    public void deleteById(UUID idUtente) {
        Utente utente = this.getById(idUtente);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getNomeUtente() + utente.getCognomeUtente() + " è stato eliminato con successo!");

    }

    public Utente getByNumeroTessera(long numeroTesseraUtente) {
        try {
            return entityManager.createQuery("SELECT u FROM Utente u WHERE u.numeroTesseraUtente = :numero", Utente.class).setParameter("numero", numeroTesseraUtente).getSingleResult();

        } catch (NoResultException e) {
            System.out.println(numeroTesseraUtente + ": non trovato");
            return null;
        }

    }


    public void removeNumeroTessera(long numeroTesseraUtente) {
        Utente utente = this.getByNumeroTessera(numeroTesseraUtente);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getNomeUtente() + utente.getCognomeUtente() + " è stato eliminato con successo!");

    }

}
