package samuelvalentini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import samuelvalentini.entity.prestito.Prestito;
import samuelvalentini.exceptions.NotFoundException;
import samuelvalentini.exceptions.NotSavedException;

import java.util.List;
import java.util.UUID;

public class PrestitoDAO {
    private final EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Prestito newPrestito) {
        try {
            EntityTransaction transaction = this.entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newPrestito);
            transaction.commit();
            System.out.println("Il prestito di " + newPrestito.getUtente() + ", della pubblicazione " + newPrestito.getPubblicazione() + " è stato salvato con successo con id " + newPrestito.getIdPrestito());
        } catch (Exception e) {
            throw new NotSavedException(newPrestito);
        }

    }

    public Prestito getById(UUID idPrestito) {
        Prestito prestito = entityManager.find(Prestito.class, idPrestito);
        if (prestito == null) throw new NotFoundException(idPrestito);
        return prestito;

    }

    public void deleteById(UUID idPrestito) {
        Prestito prestito = this.getById(idPrestito);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(prestito);
        transaction.commit();
        System.out.println("Il prestito di " + prestito.getUtente() + ", della pubblicazione " + prestito.getPubblicazione() + " è stato eliminato con successo!");

    }

    public List<Prestito> getPrestitoByNumeroTessera(long numeroTesseraPrestito) {

        return entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTesseraUtente = :numero", Prestito.class).setParameter("numero", numeroTesseraPrestito).getResultList();


    }


//    public void removeNumeroTessera(long numeroTesseraPrestito) {
//        Prestito prestito = this.getByNumeroTessera(numeroTesseraPrestito);
//        EntityTransaction transaction = this.entityManager.getTransaction();
//        transaction.begin();
//        entityManager.remove(prestito);
//        transaction.commit();
//        System.out.println("L'prestito " + prestito.getNomePrestito() + prestito.getCognomePrestito() + " è stato eliminato con successo!");
//
//    }

}
