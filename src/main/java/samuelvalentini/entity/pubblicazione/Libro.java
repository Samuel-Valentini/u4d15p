package samuelvalentini.entity.pubblicazione;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro extends Pubblicazione {
    @Column(name = "nome_cognome_autore", nullable = false)
    private String nomeCognomeAutore;
    @Column(name = "genere_principale", nullable = false)
    private String generePrincipale;

    public Libro(String codiceISBN, String titolo, short annoPubblicazione, int numeroPagine, String nomeCognomeAutore, String generePrincipale) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        if (nomeCognomeAutore == null || nomeCognomeAutore.isBlank())
            throw new IllegalArgumentException("L'autore non può essere vuoto");
        this.nomeCognomeAutore = nomeCognomeAutore;
        if (generePrincipale == null || generePrincipale.isBlank())
            throw new IllegalArgumentException("Il genere non può essere vuoto");
        this.generePrincipale = generePrincipale;
    }

    protected Libro() {
    }

    public String getNomeCognomeAutore() {
        return nomeCognomeAutore;
    }

    public void setNomeCognomeAutore(String nomeCognomeAutore) {
        if (nomeCognomeAutore == null || nomeCognomeAutore.isBlank())
            throw new IllegalArgumentException("L'autore non può essere vuoto");
        this.nomeCognomeAutore = nomeCognomeAutore;
    }

    public String getGenerePrincipale() {
        return generePrincipale;
    }

    public void setGenerePrincipale(String generePrincipale) {
        if (generePrincipale == null || generePrincipale.isBlank())
            throw new IllegalArgumentException("Il genere non può essere vuoto");
        this.generePrincipale = generePrincipale;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nomeCognomeAutore='" + nomeCognomeAutore + '\'' +
                ", generePrincipale='" + generePrincipale + '\'' + ", " +
                super.toString() + "} ";
    }
}
