package samuelvalentini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import samuelvalentini.dao.PubblicazioneDAO;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo_bibliografico");


    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager();

        //test

//        //test isbn validation
//
//        try {
//            Libro testIsbn = new Libro("55356", "Ciao", (short) 2020, 350, "Arturo Sempronio", "Fantasy");
//            System.out.println("libro creato nell'app");
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            Libro testIsbn = new Libro("5535622896", "Ciao", (short) 2020, 350, "Arturo Sempronio", "Fantasy");
//            System.out.println("libro creato nell'app");
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            Libro testIsbn = new Libro("9788820068066", "Ciao", (short) 2020, 350, "Arturo Sempronio", "Fantasy");
//            System.out.println("libro creato nell'app");
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }


        PubblicazioneDAO pubblicazioneDAO = new PubblicazioneDAO(entityManager);
//
//        // test salvataggio pubblicazione
//
//        Libro libro1;
//        try {
//            libro1 = new Libro("9788820068066", "Ciao", (short) 2020, 350, "Arturo Sempronio", "Fantasy");
//            System.out.println("libro creato nell'app");
//            pubblicazioneDAO.save(libro1);
//            System.out.println("libro salvato");
//
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }

//        //test cancellazione
//
//        try {
//
//            pubblicazioneDAO.deleteById(UUID.fromString("020ffca7-ee8b-4999-846e-f48672640e19"));
//
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }

//        //test getByISBN
//
//        Libro libro1daServer = (Libro) pubblicazioneDAO.getByISBN("9788820068066");
//        System.out.println(libro1daServer);

//        //test removeByISBN
//
//        pubblicazioneDAO.removeByISBN("9788820068066");

//        //test salvataggio rivista
//
//
//        Rivista rivista1;
//
//        try {
//            rivista1 = new Rivista("8820068060", "Ciao", (short) 2020, 350, PeriodicitaRivista.SEMESTRALE);
//            System.out.println("rivista creato nell'app");
//            pubblicazioneDAO.save(rivista1);
//            System.out.println("rivista salvata");
//
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }

//        //test cerca per anno
//
//        List<Pubblicazione> pubblicazioni2020 = pubblicazioneDAO.getByYear((short) 2020);
//        System.out.println(pubblicazioni2020);

        entityManager.close();
        emf.close();
        System.out.println("tutto ok");


    }


}
