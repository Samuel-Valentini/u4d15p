package samuelvalentini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

        entityManager.close();
        emf.close();
        System.out.println("tutto ok");


    }


}
