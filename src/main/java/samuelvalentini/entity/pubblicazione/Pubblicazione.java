package samuelvalentini.entity.pubblicazione;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pubblicazioni")
public abstract class Pubblicazione {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_pubblicazione")
    private UUID idPubblicazione;
    @Column(name = "codice_isbn", nullable = false, unique = true, length = 13)
    private String codiceISBN;
    @Column(name = "titolo", nullable = false)
    private String titolo;
    @Column(name = "anno_pubblicazione", nullable = false)
    private short annoPubblicazione;
    @Column(name = "numero_pagine", nullable = false)
    private int numeroPagine;

    public Pubblicazione(UUID idPubblicazione, String codiceISBN, String titolo, short annoPubblicazione, int numeroPagine) {
        this.idPubblicazione = idPubblicazione;
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Pubblicazione() {
    }

    public UUID getIdPubblicazione() {
        return idPubblicazione;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    //lasciamo set per ISBN in caso di errori di inserimento
    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public short getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(short annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
