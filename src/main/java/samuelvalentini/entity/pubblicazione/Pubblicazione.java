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

    private String validateISBN(String codiceISBN) {

        if (codiceISBN == null) {
            throw new IllegalArgumentException("ISBN non valido");
        }

        if (codiceISBN.length() != 10 && codiceISBN.length() != 13) {
            throw new IllegalArgumentException("ISBN non valido");
        }
        if (codiceISBN.length() == 10) {
            int total = 0;
            int actual;

            for (int i = 0; i < 10; i++) {

                if (i == 9 && (codiceISBN.charAt(i) == 'X' || codiceISBN.charAt(i) == 'x')) {
                    actual = 10;

                } else if (Character.isDigit(codiceISBN.charAt(i))) {
                    actual = codiceISBN.charAt(i) - '0';

                } else throw new IllegalArgumentException("ISBN non valido");


                total += (i + 1) * actual;

            }

            if (total % 11 != 0) {
                throw new IllegalArgumentException("ISBN non valido");
            }

        } else {
            for (int i = 0; i < 13; i++) {
                if (!Character.isDigit(codiceISBN.charAt(i))) {
                    throw new IllegalArgumentException("ISBN non valido");
                }
            }
            int total = 0;
            int actual;
            for (int i = 0; i < 12; i++) {
                if (i % 2 == 0) {
                    actual = codiceISBN.charAt(i) - '0';
                } else {
                    actual = (codiceISBN.charAt(i) - '0') * 3;
                }

                total += actual;
            }

            int check = (10 - (total % 10)) % 10;

            if (check != (codiceISBN.charAt(12) - '0')) throw new IllegalArgumentException("ISBN non valido");


        }
        return codiceISBN;

    }
}
